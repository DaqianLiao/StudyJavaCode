package com.ldq.study.tcp.pkg;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public static void nomal() throws IOException {
        // 创建 Socket 客户端并尝试连接服务器端
        Socket socket = new Socket("127.0.0.1", 9999);
        // 发送的消息内容
        final String message = "Hi,Java.";
        // 使用输出流发送消息
        try (OutputStream outputStream = socket.getOutputStream()) {
            // 给服务器端发送 10 次消息
            for (int i = 0; i < 10; i++) {
                // 发送消息
                outputStream.write(message.getBytes());
            }
        }
    }

    public static void fixLength() throws IOException {
        // 创建 Socket 客户端并尝试连接服务器端
        Socket socket = new Socket("127.0.0.1", 9999);
        int BYTE_LENGTH = 8;  // 字节长度
        // 发送的消息内容
        final String message = "Hi,Java.";
        // 使用输出流发送消息
        try (OutputStream outputStream = socket.getOutputStream()) {
            byte[] bytes = new byte[BYTE_LENGTH];
            int idx = 0;
            for (byte b : message.getBytes()) {
                bytes[idx] = b;
                idx++;
            }
            // 给服务器端发送 10 次消息
            for (int i = 0; i < 10; i++) {
                // 发送消息
                outputStream.write(message.getBytes());
            }
        }
    }
    public static void main(String[] args) throws IOException {

        fixLength();
    }
}
