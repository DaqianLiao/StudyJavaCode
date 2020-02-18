package com.ldq.study.network.tcp;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.*;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket  socket = new Socket();
        //读取流超时时间
        socket.setSoTimeout(3000);
        //连接本地、端口2000，超时时间3000ms
        socket.connect(new InetSocketAddress(Inet4Address.getLocalHost(),2000),5000);
        System.out.println("已发起服务器连接，并进入后续流程");
        System.out.println("客户端信息：" + socket.getLocalAddress() + " P:" + socket.getLocalPort());
        System.out.println("服务端信息：" + socket.getInetAddress() + " P:" + socket.getPort());

        try {
            //发送接收数据
            todo(socket);
        }catch (Exception e){
            System.out.println("连接异常，请关闭！");
        }

        socket.close();
        System.out.println("socket 已关闭，客户端退出！");
    }

    public static void todo(Socket client) throws IOException{
        //获取键盘输入流
        InputStream in = System.in;
        BufferedReader input = new BufferedReader(new InputStreamReader(in));


        //得到Socket输出流，并转化为打印流
        OutputStream outputStream = client.getOutputStream();
        PrintStream printStream = new PrintStream(outputStream);


        //得到Socket输入流，表示从服务器端接收到返回信息
        InputStream inputStream = client.getInputStream();
        BufferedReader socketInput = new BufferedReader(new InputStreamReader(inputStream));

        boolean isOn = true;
        do {
            //从键盘中获取一行数据
            String str = input.readLine();
            System.out.println("客户端从键盘流中获取字符为：" + str);
            //发送到服务器
            printStream.println(str);
            System.out.println("客户端已经字符发送给服务端");
            //从服务器中读取一行数据
            String socketStr = socketInput.readLine();
            System.out.println("服务端返回信息：" + socketStr);
            if ("bye".equalsIgnoreCase(socketStr)){
                isOn = false;
                System.out.println("服务端已退出！");
            }
        }while (isOn);

        socketInput.close();
        printStream.close();

    }
}
