/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package websocket_client;

import com.google.gson.Gson;
import java.net.URI;
import observers.IObservable;
import observers.IObserver;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;

/**
 *
 * 
 */
public class WebSocket_Client extends WebSocketClient implements IObservable {

    public IObserver _OBSERVER;
    public Gson gson = new Gson();

    public WebSocket_Client(URI pServerUri, Draft pDraft) {
        super(pServerUri, pDraft);

    }

    /**
     * This method use the handshacke for stablish the connection whit server
     *
     * @param pServerHandshacke
     */
    public void onOpen(ServerHandshake pServerHandshacke) {
        System.out.println("CONECTADO" + pServerHandshacke.toString());

    }

    /**
     * This methods receives the information sent by the server
     *
     * @param pdata
     */
    @Override
    public void onMessage(String pdata) {

        notifyObservers(gson.fromJson(pdata, Coordinate.class));
        System.out.println("Recibiendo" + pdata);
    }

    /**
     * This method close the connection with the server
     *
     * @param pInt
     * @param pString
     * @param pBln
     */
    @Override
    public void onClose(int pInt, String pString, boolean pBln) {
        System.out.println("CLOSING CONNECTION");
    }

    /**
     * This method send a error exception on the connection with the server
     *
     * @param pExcptn
     */
    @Override
    public void onError(Exception pExcptn) {
        System.err.println("ERROR" + pExcptn.toString());
    }

    /**
     * PATTERN OBSERVER This method add an inteface adds to notify the data
     * received by the server
     *
     * @param pObserver
     */
    @Override
    public void registerObserver(IObserver pObserver) {
        _OBSERVER = pObserver;
    }

    /**
     * PATTERN OBSERVER this method remove an instace of the actual interface
     *
     * @param pObserver
     */
    @Override
    public void removeObserver(IObserver pObserver) {
        _OBSERVER = null;
    }

    /**
     * PATTERN OBSERVER this method notifies the current server data received
     *
     * @param pNew
     */
    @Override
    public void notifyObservers(Coordinate pNew) {
        _OBSERVER.update(pNew);
    }

    /**
     * this method sends the first coordinate to the server
     *
     * @param pToSend
     */
    public void RegisterSend(Coordinate pToSend) {
        System.out.println("SENDING COORDINATE" + pToSend.toString());
        try {
            this.send(gson.toJson(pToSend));
        } catch (Exception ex) {
            System.err.println(ex.toString());
        }
    }
}
