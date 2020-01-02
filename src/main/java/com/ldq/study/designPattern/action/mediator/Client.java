package com.ldq.study.designPattern.action.mediator;

/**
 * 中介模式：
 *
 */
public class Client {
    public static void main(String[] args) {
        CurtainSmartDeviceImpl csd = new CurtainSmartDeviceImpl();
        MusicSmartDeviceImpl msd = new MusicSmartDeviceImpl();

        ConcreteSmartMediatorImpl concreteSmartMediator = new ConcreteSmartMediatorImpl(csd, msd);

        csd.operate("open",concreteSmartMediator);
        msd.operate("close",concreteSmartMediator);
    }
}
