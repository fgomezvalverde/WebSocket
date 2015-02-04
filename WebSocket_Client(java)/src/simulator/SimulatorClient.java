package simulator;

import gui.Window;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.java_websocket.drafts.Draft_10;
import websocket_client.Coordinate;
import websocket_client.WebSocket_Client;

/**
 * This class make the simulation of a amount of clients connected to the
 * server, the amount of client can be changed on simulator.Configuration
 *
 * 
 */
public class SimulatorClient extends Thread {

    /**
     * Run the new thread thats means the new client, with his GUI and WebSocket
     *
     * @throws URISyntaxException
     * @throws InterruptedException
     */
    @Override
    public void run() {

        try {
            WebSocket_Client con = new WebSocket_Client(Configuration.GetURI(), new Draft_10());
            Coordinate temp_coordinate = new Coordinate(ran.nextInt(Configuration._VALUE_LIMIT), ran.nextInt(Configuration._DIRECTION_LIMIT));
            final Window GUI = new Window();

            con.connect();

            Thread.sleep(Configuration._SLEEP_TIME);
            con.RegisterSend(temp_coordinate);
            con.registerObserver(GUI);

            _WINDOWS.add(GUI);
            _WS_CLIENTS.add(con);
            _POSITION_CLIENT.add(temp_coordinate);

            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    GUI.setVisible(true);
                }
            });
        } catch (Exception ex) {
            System.err.println("ERROR ON RUNNING SIMULATOR THREAD" + ex.toString());
        }

    }
    private List<Window> _WINDOWS = new ArrayList();
    private List<WebSocket_Client> _WS_CLIENTS = new ArrayList();
    private List<Coordinate> _POSITION_CLIENT = new ArrayList();
    private Random ran = new Random();
}
