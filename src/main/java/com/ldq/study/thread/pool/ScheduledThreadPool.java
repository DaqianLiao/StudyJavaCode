package com.ldq.study.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {
    public static void execute(){
        // 创建一个线程池对象
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(3);

        // 可以执行Runnable对象或者Callable对象代表的线程
        for (int i = 0; i < 10; i++) {
            System.out.println("now is " + System.currentTimeMillis());
            pool.schedule(new MyRunnable(),10, TimeUnit.SECONDS);

        }


        //结束线程池
        pool.shutdown();
    }
}
