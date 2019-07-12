package com.ldq.study.designPattern.action.nullObject;


/**
 * 空对象，可以定义对象的默认值，或者默认行为
 */
public class NullCustomerImpl extends Customer {
    @Override
    public boolean isNil() {
        return true;
    }

    @Override
    public String getName() {
        return "not available name";
    }
}
