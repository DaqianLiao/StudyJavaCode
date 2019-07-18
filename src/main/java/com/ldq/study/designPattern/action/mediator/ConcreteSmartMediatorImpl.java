package com.ldq.study.designPattern.action.mediator;

/**
 * 具体的中介实现类
 */
public class ConcreteSmartMediatorImpl extends SmartMediator {
    public ConcreteSmartMediatorImpl(SmartDevice cd, SmartDevice md) {
        super(cd, md);
    }

    @Override
    public void curtain(String instruction) {
        cd.readyState(instruction);
        md.readyState(instruction);
    }

    @Override
    public void music(String instruction) {
        cd.readyState(instruction);
        md.readyState(instruction);
    }
}
