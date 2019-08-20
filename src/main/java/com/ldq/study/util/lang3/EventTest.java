package com.ldq.study.util.lang3;

import org.apache.commons.lang3.event.EventListenerSupport;
import org.junit.Test;

import static java.lang.System.out;

public class EventTest {

    @Test
    /**
     *
     */
    public void name() {
        //通过接口创建EventListenerSupport
        EventListenerSupport<Hello> support = EventListenerSupport.create(Hello.class);
        //实现监听器
        support.addListener(s -> out.println("一:" + s));
        support.addListener(s -> out.println("二:" + s));
        /**
         * 事件发生时,触发监听器.
         * fire方法会返回IListener的代理类.
         * 运行IListener的方法,会通过代理允许所有注册监听器的相同方法.
         */
        support.fire().print("zhangliangbo");
    }

}
