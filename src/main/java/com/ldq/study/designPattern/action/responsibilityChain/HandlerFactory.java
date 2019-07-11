package com.ldq.study.designPattern.action.responsibilityChain;

/**
 * 责任人的工厂方法：简单工厂方法
 */
public class HandlerFactory {

    public static SalerHandlerImpl createHandler() {
        SalerHandlerImpl saler = new SalerHandlerImpl();
        LeaderHandlerImpl leader = new LeaderHandlerImpl();
        ManagerHandlerImpl manager = new ManagerHandlerImpl();
        VpHandlerImpl vp = new VpHandlerImpl();
        CeoHandlerImpl ceo = new CeoHandlerImpl();

        saler.setNextHandler(leader);
        leader.setNextHandler(manager);
        manager.setNextHandler(vp);
        vp.setNextHandler(ceo);

        return saler;
    }
}
