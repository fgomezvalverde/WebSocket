using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Net.Sockets;
using System.Net;
using System.Threading;
using System.Security.Cryptography;
using Alchemy.Classes;
using Newtonsoft.Json;
using System.Collections.Concurrent;
using Alchemy;
using WebSockect_Server.wsServer;

namespace WebSockect_Server
{
    //Create the server and handle the methods that he will carry like; send,connect,receive,etc
    class WebSokectServer
    {

        //Create the instance and connect the methods with the server
        public WebSokectServer()
        {
            _MANAGER = new WebSocketManager();
            _MANAGER._ONLINE_USERS = new ConcurrentDictionary<User, Coordinate>();
            _SERVER = new WebSocketServer(_PORT, IPAddress.Any)
            {
                OnReceive = OnReceive,
                OnSend = OnSend,
                OnConnected = OnConnect,
                OnDisconnect = OnDisconnect,
                TimeOut = new TimeSpan(0, 5, 0)
            };
            
        }

        //Begin to listen new clients from any IP
        public void Listen()
        {
            _SERVER.Start();
            Console.WriteLine("SERVER IS LISTENING");
            // Accept commands on the console and keep it alive
            while (true) { }
        }

        // Got the initial connetion from a client
        public void OnConnect(UserContext context)
        {
            Console.WriteLine("Client Connection From : " + context.ClientAddress);

        }

        //Receive the data from a client, reportall and refresh him self
        public void OnReceive(UserContext context)
        {
            Console.WriteLine("Received Data From :" + context.ClientAddress);
            try
            {
                string obj_string = context.DataFrame.ToString();
                Console.WriteLine(obj_string);
                dynamic obj = JsonConvert.DeserializeObject(obj_string);
                _MANAGER.ReportAll(obj_string);

                
                var newUser = new User { Context = context };
                _MANAGER.AddClient(newUser, new Coordinate { _Coordinate = obj._Coordinate, _Direction = obj._Direction });
                _MANAGER.RefreshMe(context);    // IF U WANT TO CLIENT PAINT HIM SELF THE COORDINATE , PUT IT AFTER ADDDED
            }
            catch (Exception e) 
            {
                var r = new Data { _RESPONSE = (int)ResponseType.ERROR, _TEXT = e.Message.ToString() };
                context.Send(JsonConvert.SerializeObject(r));
            }
        }

        //Called when the server need to send information to client
        public void OnSend(UserContext context)
        {
            Console.WriteLine("Data Send To : " + context.ClientAddress);
        }

        //Called when a client was disconnect
        public void OnDisconnect(UserContext context)
        {
            Console.WriteLine("Client Disconnected : " + context.ClientAddress);
            User toDelete = new User() ;
            foreach (var u in _MANAGER._ONLINE_USERS.Keys)
            {
                if (context.ClientAddress.Equals(u.Context.ClientAddress))
                {
                    toDelete = u;
                }
            }

            Coordinate trash;
            _MANAGER.RemoveClient(toDelete);  
        }


        //Handle a error when in some of the server action got a error
        private void SendError(string errorMessage, UserContext context)
        {
            var r = new Data { _RESPONSE = (int)ResponseType.ERROR, _TEXT = errorMessage };

            context.Send(JsonConvert.SerializeObject(r));
        }


        protected WebSocketServer _SERVER;
        protected int _PORT = 8080;
        protected WebSocketManager _MANAGER;
        
    }
}