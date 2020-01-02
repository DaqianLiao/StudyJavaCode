package com.ldq.study.designPattern.struct.proxy.staticProxy;

public class Client {

    public static void main(String[] args) {
        System.out.println("自己买房的过程");
        BuyHouse buyHouse = new BuyHouseImpl();
        buyHouse.buyHouse();
        ((BuyHouseImpl)buyHouse).sellHouse();
        System.out.println("==================");
        System.out.println("找中介买房");
        BuyHouse proxy = new BuyHouseProxy(buyHouse);
        proxy.buyHouse();


    }
}
