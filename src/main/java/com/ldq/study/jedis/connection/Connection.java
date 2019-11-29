package com.ldq.study.jedis.connection;

import com.ldq.study.jedis.protocol.Protocol;

import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.net.Socket;

public class Connection {
    private Socket socket;
    private String host;
    private int port;
    private InputStream inputStream;
    private OutputStream outputStream;

    public Connection(String host, int port) {
        this.host = host;
        this.port = port;
    }

    /**
     * IO 复用
     *
     * @return
     */
    public Connection connection() {
        try {
            if (!isConnection()) {
                socket = new Socket(host, port);
                outputStream = socket.getOutputStream();
                inputStream = socket.getInputStream();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    private boolean isConnection() {
        return socket != null && socket.isConnected() && socket.isBound();
    }


    public void sendCommand(Protocol.Command command, byte[]... datas) {
        connection();

        Protocol.sendCommand(outputStream, command, datas);
    }

    public String getAck() {
        byte[] ack = new byte[1024];
        try {
            socket.getInputStream().read(ack);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new String(ack);
    }
}
