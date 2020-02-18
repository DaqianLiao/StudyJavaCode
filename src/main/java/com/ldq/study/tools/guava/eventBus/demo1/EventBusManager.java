package com.ldq.study.tools.guava.eventBus.demo1;

import com.google.common.eventbus.EventBus;

public class EventBusManager {

    private static EventBus eventBus = new EventBus();

    public static EventBus getInstance(){
        return eventBus;
    }

    public static void register(Object obj) {
        eventBus.register(obj);
    }

    public static void post(Object obj) {
        eventBus.post(obj);
    }

    public static void unregister(Object obj) {
        eventBus.unregister(obj);
    }
}
