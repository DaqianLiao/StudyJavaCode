package com.ldq.study.designPattern.struct.proxy.staticProxy;

/**
 * 实现服务接口
 */
public class BuyHouseImpl implements BuyHouse {
    @Override
    public void buyHouse() {
        System.out.println("我要买房");
    }

    public void sellHouse(){
        System.out.println("低价买入的房子，高价卖出");
    }
}
