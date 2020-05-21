package com.ldq.study.rpc.rpc1;

import com.ldq.study.rpc.common.User;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 第一个版本：
 * 客户端服务端的通过Socket连接，传输二进制数据流
 * 只能调用单个Service的单个方法
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8888);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeInt(123);

        socket.getOutputStream().write(baos.toByteArray());
        socket.getOutputStream().flush();

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        int id = dis.readInt();
        String name = dis.readUTF();
        User user = new User(id, name);
        System.out.println(user);

        dos.close();
        dis.close();
        socket.close();
    }
}
