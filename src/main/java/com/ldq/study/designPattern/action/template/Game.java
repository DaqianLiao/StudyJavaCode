package com.ldq.study.designPattern.action.template;

/**
 * 抽象模版
 * 定义一个不能被重写的模版方法
 * 在方法中，可以预留一部分用户自定义的抽象方法
 * 也可以定义一些通用的方法
 */
public abstract class Game {

    //定义了一个不被修改的模版方法
    public final void play(){
        init();
        startPlay();
        endPlay();
    }

    abstract void endPlay();

    abstract void startPlay();

    private void init(){
        System.out.println("比赛前的各种准备工作");
    }
}
