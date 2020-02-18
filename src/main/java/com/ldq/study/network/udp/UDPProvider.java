package com.ldq.study.network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class UDPProvider {
    public static void main(String[] args) throws IOException {
        System.out.println("UDPProvider start~~~");
        //作为接受者，指定一个端口用于接收数据
        DatagramSocket socket = new DatagramSocket(2000);

        final byte[] buf = new byte[512];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        //接收数据
        socket.receive(packet);
        //获取接收的详细信息
        String hostAddress = packet.getAddress().getHostAddress();
        int port = packet.getPort();
        int length = packet.getLength();
        String receiveStr = new String (packet.getData(),0,length);

        System.out.println("length = " + length);
        System.out.println("hostAddress = " + hostAddress);
        System.out.println("port = " + port);
        System.out.println("receiveStr = " + receiveStr);


        //构建回收数据
        String responseData = receiveStr;
        DatagramPacket response = new DatagramPacket(responseData.getBytes(), length);
        response.setAddress(packet.getAddress());
        response.setPort(port);
        socket.send(response);

        System.out.println("UDPProvide end");
        //关闭资源
        socket.close();
    }
}
