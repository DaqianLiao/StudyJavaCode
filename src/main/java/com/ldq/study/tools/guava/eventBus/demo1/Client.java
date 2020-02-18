package com.ldq.study.tools.guava.eventBus.demo1;

import com.google.common.eventbus.EventBus;
import org.junit.Test;

public class Client {
    @Test
    public void main() {

        StringObserver stringObserver = new StringObserver();
        IntegerObserver integerObserver = new IntegerObserver();

        EventBusManager.register(stringObserver);
        EventBusManager.register(integerObserver);

        EventBusManager.post("I am String");
        EventBusManager.post("I am integer");
        EventBusManager.post(123);
        //不会被消费
        EventBusManager.post(223.432);
        EventBusManager.unregister(stringObserver);

        System.out.println("*************StringObserver is unregister*************");
        EventBusManager.post(345);
        EventBusManager.post("I am String");


    }
}
