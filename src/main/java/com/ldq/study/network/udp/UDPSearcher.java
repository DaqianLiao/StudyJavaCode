package com.ldq.study.network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public class UDPSearcher {
    public static void main(String[] args) throws IOException {
        System.out.println("UDPSearcher start~~~");
        //作为发送者，无须指定端口
        DatagramSocket socket = new DatagramSocket();

        //构建回收数据
        String requestData = "Im search";
        DatagramPacket request = new DatagramPacket(requestData.getBytes(), requestData.length());
        request.setAddress(InetAddress.getLocalHost());
        request.setPort(2000);
        socket.send(request);


        final byte[] buf = new byte[512];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        //接收数据
        socket.receive(packet);
        //获取接收的详细信息
        String hostAddress = packet.getAddress().getHostAddress();
        int port = packet.getPort();
        int length = packet.getLength();
        String receiveStr = new String(packet.getData(), 0, length);

        System.out.println("length = " + length);
        System.out.println("hostAddress = " + hostAddress);
        System.out.println("port = " + port);
        System.out.println("receiveStr = " + receiveStr);


        System.out.println("UDPSearcher end");
        //关闭资源
        socket.close();
    }
}
