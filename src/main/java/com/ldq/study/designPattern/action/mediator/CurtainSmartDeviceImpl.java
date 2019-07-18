package com.ldq.study.designPattern.action.mediator;

/**
 * 具体的窗帘设备
 */
public class CurtainSmartDeviceImpl extends SmartDevice {
    @Override
    public void readyState(String instruction) {
        System.out.println("窗帘设备准备：" + instruction);
    }

    @Override
    public void operate(String instruction, SmartMediator smartMediator) {
        smartMediator.curtain(instruction);
        System.out.println("窗帘已经：" + instruction);
    }
}
