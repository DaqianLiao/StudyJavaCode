package com.ldq.study.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建一个单线程的线程池。此线程池支持定时以及周期性执行任务的需求
 */
public class SingleThreadPool {
    public static void execute() {
        // 创建一个线程池对象
        ExecutorService pool = Executors.newSingleThreadExecutor();

        // 可以执行Runnable对象或者Callable对象代表的线程
        for (int i = 0; i < 10; i++) {
            pool.submit(new MyRunnable());
        }

        //结束线程池
        pool.shutdown();
    }
}
