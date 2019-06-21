package com.ldq.study.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *创建一个可缓存的线程池
 * 线程池的大小超过了处理任务所需要的线程，那么就会回收部分空闲（60秒不执行任务）的线程
 * 当任务数增加时，此线程池又可以智能的添加新线程来处理任务
 * 此线程池不会对线程池大小做限制，
 * 线程池大小完全依赖于操作系统（或者说JVM）能够创建的最大线程大小。
 */

public class CacheThreadPool {

    public static void execute() {
        // 创建一个线程池对象
        ExecutorService pool = Executors.newCachedThreadPool();

        // 可以执行Runnable对象或者Callable对象代表的线程
        for (int i = 0; i < 10; i++) {
            pool.submit(new MyRunnable());
            System.out.println(" active thread num = "+((ThreadPoolExecutor) pool).getActiveCount());
        }

        //结束线程池
        pool.shutdown();
    }
}
