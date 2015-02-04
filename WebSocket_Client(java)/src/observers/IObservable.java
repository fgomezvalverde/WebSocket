package observers;

import websocket_client.Coordinate;

/**
 * This class represents an observable object, or "data" in the model-view
 * paradigm. An observable object can have one or more observers.
 * An observer may be any object that implements interface Observer.
 * 
 */
public interface IObservable {

    /**
     * Adds an pObserver to the set of observers for this object, provided that
     * it is not the same as some pObserver already in the set.
     * @param pObserver
     */
    public void registerObserver(IObserver pObserver);

    /**
     * Deletes an pObserver from the set of observers of this object.
     * @param pObserver
     */
    public void removeObserver(IObserver pObserver);

    /**
     * If this object has changed, as indicated by the hasChanged method, then
     * notify all of its observers and then call the clearChanged method to
     * indicate that this object has no longer changed.
     *
     * @param pNew
     */
    public void notifyObservers(Coordinate pNew);
}
