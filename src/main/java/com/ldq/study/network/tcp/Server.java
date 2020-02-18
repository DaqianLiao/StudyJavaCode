package com.ldq.study.network.tcp;

import com.ldq.study.gc.exception.Ex;

import java.io.*;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress(Inet4Address.getLocalHost(),2000));
        System.out.println("服务器准备就绪，并进入后续流程");
        System.out.println("服务端信息：" + server.getInetAddress() + " P:" + server.getLocalPort());

        for (; ; ) {
            //得到客户端
            Socket socket = server.accept();
            //客户端构建异步线程
            ClientHandler clientHandler = new ClientHandler(socket);
            //启动线程
            clientHandler.start();
        }

    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private boolean flag = true;

        ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            super.run();
            System.out.println("连接到服务端的客户端信息：" + socket.getInetAddress() + " P:" + socket.getPort());

            try {

                //得到Socket输出流，并转化为打印流，用于发送数据给客户端
                PrintStream socketOutput = new PrintStream(socket.getOutputStream());
                //得到Socket输入流，表示服务器端从客户端接收到的数据
                BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                do {
                    String clientStr = socketInput.readLine();
                    System.out.println("服务端接收到客户端发过来的数据为：" + clientStr);

                    if("bye".equalsIgnoreCase(clientStr)){
                        flag = false;
                        System.out.println("客户端已经退出");
                        socketOutput.println("bye");
                    }else{
                        System.out.println("服务端已接收到数据:"+clientStr);
                        socketOutput.println("服务端已接收到数据:"+clientStr);
                    }
                } while (flag);

                socketOutput.close();
                socketInput.close();
            } catch (Exception e) {
                System.out.println("连接断开异常");
            }finally {
                try{
                    socket.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println("服务端" + Thread.currentThread().getName() +"监听客户端的连接已经关闭");
            }

        }

    }
}
