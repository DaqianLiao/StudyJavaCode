package com.ldq.study.rpc.rpc6;

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
        ObjectOutputStream oos = new ObjectOutputStream(out);

        String className = dis.readUTF();
        String methodName = dis.readUTF();
        Class[] parameterTypes = (Class[]) dis.readObject();
        Object[] args = (Object[]) dis.readObject();

//        利用反射加载该类
        Class<?> aClass = Class.forName(className);

//        UserService userService = new UserServiceImpl();

        System.out.println(aClass.getName());
        Method method = aClass.getMethod(methodName, parameterTypes);
//        实例化该类的对象，对象必须具有无参构造器，
//        才可以直接实例化，否则会抛出java.lang.InstantiationException异常
        Object o = method.invoke(aClass.newInstance(), args);
        oos.writeObject(o);
    }
}
