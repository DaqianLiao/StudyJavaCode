package com.ldq.study.designPattern.action.template;

/**
 * 具体的实现类，根据自己不同的需求定制化模版中的抽象方法
 */
public class FootballGameImpl extends Game {

    @Override
    void endPlay() {
        System.out.println("比赛结束了，中国队获得大力神杯，创造了历史！");
    }

    @Override
    void startPlay() {
        System.out.println("中国队和巴西队即将开赛。。。。。");
    }
}
