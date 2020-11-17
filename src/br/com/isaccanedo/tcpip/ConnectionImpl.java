package br.com.isaccanedo.tcpip;

import java.io.IOException;
import java.net.ConnectException;

/**
 * @author Isac Canedo
 */

public interface ConnectionImpl {

    /**
     *
     * @throws IOException
     */

    public void connect() throws IOException;
    public void disconect() throws ConnectException;
    public boolean isConnected();

}
