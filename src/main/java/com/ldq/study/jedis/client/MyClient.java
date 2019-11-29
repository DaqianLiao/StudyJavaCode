package com.ldq.study.jedis.client;

import com.ldq.study.jedis.connection.Connection;
import com.ldq.study.jedis.protocol.Protocol;

public class MyClient {
    private Connection connection;

    public MyClient(String host, int port) {
        this.connection = new Connection(host, port);
    }

    public String set(String key, String value) {

        connection.sendCommand(Protocol.Command.SET, key.getBytes(), value.getBytes());

        return connection.getAck();
    }

    public String get(String key) {
        connection.sendCommand(Protocol.Command.GET, key.getBytes());

        return connection.getAck();
    }

    public static void main(String[] args) {
        MyClient client = new MyClient("localhost", 6379);
        System.out.println(client.set("mm", "luck"));
        System.out.println(client.get("mm"));

    }
}
