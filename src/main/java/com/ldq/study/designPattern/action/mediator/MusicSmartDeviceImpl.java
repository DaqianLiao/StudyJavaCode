package com.ldq.study.designPattern.action.mediator;

/**
 * 具体音乐设备
 */
public class MusicSmartDeviceImpl extends SmartDevice {
    @Override
    public void readyState(String instruction) {
        System.out.println("音乐设备准备："+ instruction);
    }

    @Override
    public void operate(String instruction, SmartMediator smartMediator) {
        smartMediator.music(instruction);
        System.out.println("音乐已经："+ instruction);
    }
}
