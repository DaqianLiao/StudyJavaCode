package com.ldq.study.rpc.rpc6;

import com.ldq.study.rpc.common.Product;
import com.ldq.study.rpc.common.ProductService;
import com.ldq.study.rpc.common.User;
import com.ldq.study.rpc.common.UserService;

import java.io.IOException;

/**
 * 第6个版本：
 * 客户端服务端的通过Socket连接，传输二进制数据流
 * 提供了一个代理Stub类，封装了底层调用网络的逻辑，
 * 使得客户端在使用UserService的方法更加简单
 *
 * Stub使用动态代理，获取服务端的的接口实现类的方法，
 * 通过代理该方法，可以远程访问服务端的实现类逻辑
 *
 */
public class Client {
    public static void main(String[] args) {
        UserService userService = (UserService) Stub.getStub(UserServiceImpl.class, UserService.class);
        System.out.println(userService.findById(123));
        System.out.println(userService.findById(345));
        System.out.println(userService.save(new User(33,"user")));

        ProductService productService = (ProductService) Stub.getStub(ProductServiceImpl.class, ProductService.class);
        System.out.println(productService.findById(99));
        System.out.println(productService.findById(789));
        System.out.println(productService.save(new Product(87,"huawei")));

    }
}
