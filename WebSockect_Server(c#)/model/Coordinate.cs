using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WebSockect_Server
{
    //Use it to transfer the data for client to server and server to client
    public class Coordinate
    {


        public int _Coordinate;
        public int _Direction;

        public Coordinate() { }
        public Coordinate(int _Coordinate, int _Direction)
        {
            this._Coordinate = _Coordinate;
            this._Direction = _Direction;
        }

        public int getCoordinate()
        {
            return _Coordinate;
        }

        public void setCoordinate(int _Coordinate)
        {
            this._Coordinate = _Coordinate;
        }

        public int getDirection()
        {
            return _Direction;
        }

        public void setDirection(int _Direction)
        {
            this._Direction = _Direction;
        }

    }

}
