package com.ldq.study.tools.guava.eventBus.demo1;

import com.google.common.eventbus.Subscribe;

public class IntegerObserver {
    /**
     * 只有通过@Subscribe注解的方法才会被注册进EventBus
     * 而且方法有且只能有1个参数，在接收到消息后，eventBus会用反射选择对应的处理函数。
     * @param msg
     */
    @Subscribe
    public void handleEvent(Integer msg) {
        System.out.println("Integer = " + msg);
    }
}

