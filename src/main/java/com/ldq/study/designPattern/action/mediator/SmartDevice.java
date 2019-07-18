package com.ldq.study.designPattern.action.mediator;

/**
 * 抽象设备类
 */
public abstract class SmartDevice {
    //相关设备打开后，使其进入准备状态
    public abstract void readyState(String instruction);
    //抽象终结者操作设备
    public abstract void operate(String instruction, SmartMediator smartMediator);

}
