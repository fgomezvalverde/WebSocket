package gui;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import simulator.Configuration;
import simulator.SimulatorClient;

/**
 * Just instance all the simulator clients and set the amount
 *
 * 
 */
public class Main {

    public static void main(String[] args) throws URISyntaxException, InterruptedException, IOException {

        SimulatorClient clients[] = new SimulatorClient[Configuration._AMOUNT_CLIENTS];
        for (int cont = 0; cont < Configuration._AMOUNT_CLIENTS; cont++) {
            clients[cont] = new SimulatorClient();
        }
        for (Thread actual : clients) {
            actual.start();
            Thread.sleep(Configuration._SLEEP_TIME);
        }

    }
}
