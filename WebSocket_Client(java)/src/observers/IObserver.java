package observers;

import websocket_client.Coordinate;

/**
 * A class can implement the Observer interface when it wants to be informed of
 * changes in observable objects.
 *
 * 
 */
public interface IObserver {

    /**
     * This method is called whenever the observed object is changed.
     *
     * @param pNew
     */
    public void update(Coordinate pNew);
}
