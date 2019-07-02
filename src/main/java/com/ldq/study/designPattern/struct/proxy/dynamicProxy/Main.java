package com.ldq.study.designPattern.struct.proxy.dynamicProxy;

import com.ldq.study.designPattern.struct.proxy.staticProxy.BuyHouse;
import com.ldq.study.designPattern.struct.proxy.staticProxy.BuyHouseImpl;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {

        BuyHouse buyHouse = new BuyHouseImpl();
        buyHouse.buyHouse();

        System.out.println("==================");
        /**
         * 第一个参数：指定当前目标类使用的类加载器，获取加载器的方法是固定的
         * 第二个参数：指定目标对象实现接口的类型，使用泛型方式确认类型
         * 第三个参数：指定动态处理器，即当前的动态代理类
         */
        BuyHouse proxy = (BuyHouse) Proxy.newProxyInstance(
                BuyHouse.class.getClassLoader(), new Class[]{BuyHouse.class}, new DynamicProxyHandler(buyHouse));
        proxy.buyHouse();
    }
}
