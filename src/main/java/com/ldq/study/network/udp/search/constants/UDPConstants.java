package com.ldq.study.network.udp.search.constants;

public class UDPConstants {
    //服务器固话UDP接收端口
    public static final int PORT_SERVER = 30201;
    //客户端回送端口
    public static final int PORT_CLIENT_RESPONSE = 30202;
    //公用头部
    public static final byte[] HEADER = new byte[]{7,7,7,7,7,7,7,7};

}
