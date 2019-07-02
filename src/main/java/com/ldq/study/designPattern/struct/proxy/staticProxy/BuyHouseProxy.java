package com.ldq.study.designPattern.struct.proxy.staticProxy;

import java.util.Random;

/**
 * 创建代理类
 * 代理类继承了服务接口，内部接受一个实体类的成员变量
 * 实际上就是代理了某个实体类的功能
 * 同时又能对实体类的功能进行管控，可提供实体类部分（或者全部）功能，
 * 也能提供实体类没有的功能
 */
public class BuyHouseProxy implements BuyHouse {

    private BuyHouse buyHouse;

    public BuyHouseProxy(BuyHouse buyHouse) {
        this.buyHouse = buyHouse;
    }

    @Override
    public void buyHouse() {
        Random random = new Random();
        if (random.nextBoolean()) {
            buyHouse.buyHouse();
        } else {
            System.out.println("房子已经卖完了，很遗憾，你买不到房子了");
        }
    }
}
