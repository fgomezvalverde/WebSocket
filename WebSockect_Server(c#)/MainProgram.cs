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

namespace WebSockect_Server
{
    class MainProgram
    {
        static void Main(string[] args)
        {
            WebSokectServer Server = new WebSokectServer();

            Thread thread = new Thread(new ThreadStart(Server.Listen));
            thread.Start();
        }
    }
}
