using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WebSockect_Server
{
    // Handle with the data from the client
    public class Data
    {
        public int _RESPONSE { get; set; }
        public int _VALUE { get; set; }
        public int _DIRECTION { get; set; }
        public String _TEXT { get; set; }
    }
}
