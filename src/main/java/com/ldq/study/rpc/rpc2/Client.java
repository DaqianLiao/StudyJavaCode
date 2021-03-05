package com.ldq.study.rpc.rpc2;

import java.io.IOException;

/**
 * 第二个版本：
 * 客户端服务端的通过Socket连接，传输二进制数据流
 * 提供了一个代理Stub类，封装了底层调用网络的逻辑，
 * 使得客户端在使用UserService的方法更加简单
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Stub stub = new Stub();
        System.out.println(stub.findById(123));
    }
}
