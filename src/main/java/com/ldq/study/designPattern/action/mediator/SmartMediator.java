package com.ldq.study.designPattern.action.mediator;

/**
 * 抽象中介类
 * 封装了和对象通信的方法
 */
public abstract class SmartMediator {
    SmartDevice cd;
    SmartDevice md;

    public SmartMediator(SmartDevice cd, SmartDevice md) {
        this.cd = cd;
        this.md = md;
    }

    public abstract void curtain(String instruction);

    public abstract void music(String instruction);
}
