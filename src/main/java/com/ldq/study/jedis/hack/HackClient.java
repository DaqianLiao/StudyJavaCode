package com.ldq.study.jedis.hack;
import	java.net.ServerSocket;

import java.io.IOException;
import java.net.Socket;

public class HackClient {

    /**
     * 模拟服务器，拦截请求
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6378);
        Socket socket = serverSocket.accept();
        byte[] bytes = new byte[1024];
        socket.getInputStream().read(bytes);
        System.out.println(new String(bytes));
    }
}
