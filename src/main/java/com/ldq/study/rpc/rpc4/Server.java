package com.ldq.study.rpc.rpc4;

import com.ldq.study.rpc.common.User;
import com.ldq.study.rpc.common.UserService;

import java.io.*;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static Boolean running = true;
    public static void main(String[] args) throws Exception {
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

    private static void process(Socket accept) throws Exception {
        InputStream in = accept.getInputStream();
        OutputStream out = accept.getOutputStream();

        ObjectInputStream dis = new ObjectInputStream(in);
        DataOutputStream dos = new DataOutputStream(out);


        String methodName = dis.readUTF();
        Class[] parameterTypes = (Class[]) dis.readObject();
        Object[] args = (Object[]) dis.readObject();

        UserService userService = new UserServiceImpl();

        Method method = userService.getClass().getMethod(methodName, parameterTypes);
        User user = (User)method.invoke(userService, args);
        dos.writeInt(user.getId());
        dos.writeUTF(user.getName());
    }
}
