using Alchemy.Classes;
using Newtonsoft.Json;
using System;
using System.Collections.Concurrent;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace WebSockect_Server.wsServer
{
    // Manage all the clients, and the options to transmite new clients to all
    public class WebSocketManager
    {
        public ConcurrentDictionary<User, Coordinate> _ONLINE_USERS { get; set; }

        //Add a client to the dictionary
        public void AddClient(User pUser, Coordinate pPosition)
        {
            _ONLINE_USERS.TryAdd(pUser, pPosition);
        }

        //Remove a client from the dictionary
        public void RemoveClient(User pToDelete)
        { 
            Coordinate trash;
            _ONLINE_USERS.TryRemove(pToDelete, out trash);
        }

        //Report a message to all the existing clients
        public void ReportAll(string message)
        {
            Console.WriteLine("REPORTING TO ALL,AMOUNT:" + _ONLINE_USERS.Count);
            foreach (var u in _ONLINE_USERS.Keys)
            {
                if (message.Equals(""))
                {
                    Console.WriteLine("ERROR < VALOR NULO");
                }
                u.Context.Send(message);
            }
        }

        //When the client was recently added, it will recibe all the information from the other clients
        public void RefreshMe(UserContext context)
        {
            foreach (var u in _ONLINE_USERS.Values)
            {
                if (u == null)
                {
                    Console.WriteLine("ERROR < VALOR NULO");
                }
                Thread.Sleep(1000);
                context.Send(JsonConvert.SerializeObject(u));
            }
        }
    }
}
