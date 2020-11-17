package br.com.isaccanedo.tcpip;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Isac Canedo
 */

public class Connection implements ConnectionImpl {

    String address;
    int port;
    Socket socket;

    /**
     *
     * @param address
     * @param port
     */

    public Connection(String address, int port) {
        super();
        this.address = address;
        this.port = port;
    }

    /**
     *
     * @throws ConnectException
     */

    @Override
    public void connect() throws ConnectException {
        if (socket == null || !socket.isConnected()){
            try {
                socket = new Socket(address, port);
            } catch (UnknownHostException unknownHostException){
                throw new ConnectException("Exceção de Host desconhecido ao criar o socket: " + unknownHostException.getLocalizedMessage());
            } catch (IOException ioException) {
                throw new ConnectException("Exceção de IO ao criar o socket: " + ioException.getLocalizedMessage());
            } catch (SecurityException securityException) {
                throw new ConnectException("Exceção de Segurança ao criar o socket: " + securityException.getLocalizedMessage());
            }
        }
        if (socket == null || socket.isConnected()) {
            throw new ConnectException("Não foi possível criar e conectar o socket");
        }
    }

    /**
     *
     * @throws ConnectException
     */

    @Override
    public void disconect() throws ConnectException {
        if (socket != null && socket.isConnected()) {
            try {
                socket.close();
                socket = null;

            } catch (IOException ioException) {

            }
        }

    }

    /**
     *
     * @return
     */

    @Override
    public boolean isConnected() {
        return socket != null && socket.isConnected();
    }

    /**
     *
     * @return
     */

    public Socket getSocket() {
        return socket;
    }
}
