package com.ldq.study.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 创建固定大小的线程池。每次提交一个任务就创建一个线程，直到线程达到线程池的最大大小
 */

public class FixThreadPool {
    public static void execute() {
        // 创建一个线程池对象
        ExecutorService pool = Executors.newFixedThreadPool(2);

        // 可以执行Runnable对象或者Callable对象代表的线程
        for (int i = 0; i < 10; i++) {
            pool.submit(new MyRunnable());
            System.out.println(" active thread num = "+((ThreadPoolExecutor) pool).getActiveCount());
        }

        //结束线程池
        pool.shutdown();
    }
}
