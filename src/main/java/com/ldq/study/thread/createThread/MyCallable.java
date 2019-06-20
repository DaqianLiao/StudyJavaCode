package com.ldq.study.thread.createThread;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() {
        System.out.println("this is MyCallable implements callable");
        return 100;
    }
}
