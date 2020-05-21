package com.ldq.study.rpc.rpc4;

import com.ldq.study.rpc.common.UserService;

import java.io.IOException;

/**
 * 第4个版本：
 * 客户端服务端的通过Socket连接，传输二进制数据流
 * 提供了一个代理Stub类，封装了底层调用网络的逻辑，
 * 使得客户端在使用UserService的方法更加简单
 *
 * Stub使用动态代理，获取服务端的UserServiceImpl的具体类的方法，
 * 通过代理该方法，可以远程访问服务端的UserServiceImpl的逻辑
 *
 */
public class Client {
    public static void main(String[] args) throws IOException {
        UserService userService = ((UserService) Stub.getStub(UserService.class));
        System.out.println(userService.findById(123));
    }
}
