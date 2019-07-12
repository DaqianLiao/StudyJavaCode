package com.ldq.study.designPattern.action.nullObject;

/**
 * 真实对象。定义具体行为
 */
public class RealCustomerImpl extends Customer {

    public RealCustomerImpl(String name) {
        this.name = name;
    }

    @Override
    public boolean isNil() {
        return false;
    }

    @Override
    public String getName() {
        return name;
    }
}
