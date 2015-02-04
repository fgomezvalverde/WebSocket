using Alchemy.Classes;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WebSockect_Server
{
    // Determinate the WebSocket from a client
    public class User
    {
        public string Name = String.Empty;
        public UserContext Context { get; set; }
    }
}
