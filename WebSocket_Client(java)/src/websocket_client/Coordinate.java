/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package websocket_client;

/**
 *
 * @author Fabian
 */
public class Coordinate {
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

    @Override
    public String toString() {
        return "Coordinate{" + "_Coordinate=" + _Coordinate + ", _Direction=" + _Direction + '}';
    }
            
}
