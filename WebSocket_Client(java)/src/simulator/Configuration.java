package simulator;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * This class contains the configuration of the WebClient
 *
 * 
 */
public class Configuration {

    /**
     * Returns the part of this request's URL from the protocol name up to the
     * query string in the first line of the HTTP request.
     *
     * @return
     * @throws URISyntaxException
     */
    public static URI GetURI() throws URISyntaxException {
        return new URI(_URI_DIRECTION);
    }
    public static final int _PORT = 8080;
    public static final String _URI_DIRECTION = "ws://localhost:" + _PORT;
    public static final int _VALUE_LIMIT = 250;
    public static final int _DIRECTION_LIMIT = 4;
    public static final int _AMOUNT_CLIENTS = 30;
    public static final int _SLEEP_TIME = 4000;
    public static int _POSITION = 0;
}
