package com.ldq.study.rpc.rpc3;

import com.ldq.study.rpc.common.User;
import com.ldq.study.rpc.common.UserService;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static Boolean running = true;
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);

        while (running){
            System.out.println("ready to accept socket");
//            如果没有连接就会阻塞
            Socket accept = server.accept();
            System.out.println("socket accept success!");
//            如果对应的Socket没有收到数据也会阻塞
            process(accept);
            accept.close();
        }
        server.close();

    }

    private static void process(Socket accept) throws IOException {
        InputStream in = accept.getInputStream();
        OutputStream out = accept.getOutputStream();

        DataInputStream dis = new DataInputStream(in);
        DataOutputStream dos = new DataOutputStream(out);

        int id = dis.readInt();
        UserService userService = new UserServiceImpl();
        User byId = userService.findById(id);
        dos.writeInt(byId.getId());
        dos.writeUTF(byId.getName());
    }
}
