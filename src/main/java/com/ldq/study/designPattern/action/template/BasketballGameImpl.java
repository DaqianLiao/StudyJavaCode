package com.ldq.study.designPattern.action.template;

public class BasketballGameImpl extends Game {
    @Override
    void endPlay() {
        System.out.println("乔丹以绝对优质战胜了科比");
    }

    @Override
    void startPlay() {
        System.out.println("科比决战乔丹");
    }
}
