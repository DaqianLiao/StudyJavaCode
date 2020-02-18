package com.ldq.study.network.udp.search.client;

import com.ldq.study.network.udp.search.client.bean.ServerInfo;

public class Client {
    public static void main(String[] args) {
        ServerInfo info = ClientSearcher.searchServer(10000);
        System.out.println("Server:" + info);
    }
}
