package com.ldq.study.thread.pool.stop;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AfterStopNewJob {
    public static void main(String[] args) {
        testNewJob();
    }

    /**
     * 当线程池关闭时，提交的新任务会被拒绝逻辑执行
     * 默认的据略逻辑就是抛出异常
     */
    private static void testNewJob() {
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue workQueue = new LinkedBlockingQueue<>();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 4, 10, unit, workQueue);
        executor.execute(()-> System.out.println("before shutdown"));
        executor.shutdown();
        executor.execute(()-> System.out.println("after shutdown! New job"));
    }
}
