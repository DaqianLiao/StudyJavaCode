package com.ldq.study.designPattern.action.responsibilityChain;

/**
 * 抽象责任链类：
 * 成员变量是上级责任人，意味着，自己处理不了的任务，就交给更高层级的责任人处理
 * 抽象方法：不同级别的人员的职责不一样，职能也不一样，自己只处理自己职能范围内的事情
 */
public abstract class Handler {

    private Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public Handler getNextHandler() {
        return nextHandler;
    }

    public abstract void handlerRequest(double request);
}
