package com.ldq.study.thread.monitor;

import java.util.concurrent.*;

/**
 * 通过ThreadPoolExecutor 监控线程池内部线程/队列/的状态
 */
public class Monitor {
    private static int nThreads = 10;
    public static ExecutorService executorService = Executors.newFixedThreadPool(nThreads);

    public static void monitor() {
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            executorService.execute(() -> {
                System.out.println("Thread.currentThread().getName() = "
                        + Thread.currentThread().getName() + ", now index = " + finalI);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Monitor.executorService;
        while (!threadPoolExecutor.isShutdown()) {
            System.out.println("=++++++++++++++=");
            int leftJobSize = threadPoolExecutor.getQueue().size();
            System.out.println("leftJobSize = " + leftJobSize);
            long completedTaskCount = threadPoolExecutor.getCompletedTaskCount();
            System.out.println("completedTaskCount = " + completedTaskCount);
            int activeCount = threadPoolExecutor.getActiveCount();
            System.out.println("activeCount = " + activeCount);
            long taskCount = threadPoolExecutor.getTaskCount();
            System.out.println("taskCount = " + taskCount);
            int poolSize = threadPoolExecutor.getPoolSize();
            System.out.println("poolSize = " + poolSize);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (leftJobSize + activeCount == 0) {
                threadPoolExecutor.shutdown();
                executorService.shutdown();
            }
        }
    }

    public static void main(String[] args) {
        monitor();
    }
}
