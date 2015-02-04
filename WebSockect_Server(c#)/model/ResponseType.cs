using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WebSockect_Server
{
    //Recognize the type of the incoming message from the client
    public enum ResponseType
    {
        CONNECTION =0,
        DISCCONECT,
        MESSAGE,
        ERROR
    }
}
