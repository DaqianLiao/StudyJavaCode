package com.ldq.study.designPattern.action.nullObject;

/**
 * 简单工厂类，定义了默认的对象名字
 */
public class CustomerFactory {

    private static final String[] names = {"lily","lucy","jack","leo"};
    public static Customer getCustomer(String name){
        for (String defaultName : names) {
            if (defaultName.equalsIgnoreCase(name)) {
                return new RealCustomerImpl(name);
            }
        }
        return new NullCustomerImpl();
    }
}
