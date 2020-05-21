package com.ldq.study.rpc.rpc2;

import com.ldq.study.rpc.common.User;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 封装了底层调用server端服务的过程
 */
public class Stub {
    public User findById(int i) throws IOException {
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


        dos.close();
        dis.close();
        socket.close();
        return user;
    }
}
