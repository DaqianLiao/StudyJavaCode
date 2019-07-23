package com.ldq.study.thread.pool.stop;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class WaitQueueJob {
    static class Task implements Runnable {
        private String name;

        public Task(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("task: " + name + " is running");
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task: " + name + " is over");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        testShutdownWaitJob();
        TimeUnit.SECONDS.sleep(5);
        System.out.println("=============");
        testShutdownNowWaitJob();
    }

    private static void testShutdownNowWaitJob() {
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        for (int i = 1; i <= 10; i++) {
            queue.add(new Task(String.valueOf(i)));
        }
        System.out.println("queue add 10 job");
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, queue);
        executor.execute(new Task("0"));
        List<Runnable> drop = executor.shutdownNow();
        System.out.println("queue size = " + queue.size() + " after shutdown");
        System.out.println("drop queue size = " + drop.size() + " after shutdown");
    }

    private static void testShutdownWaitJob() {
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        for (int i = 1; i <= 10; i++) {
            queue.add(new Task(String.valueOf(i)));
        }
        System.out.println("queue add 10 job");
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 10, TimeUnit.SECONDS, queue);
        executor.execute(new Task("0"));
        executor.shutdown();
        System.out.println("queue size = " + queue.size() + " after shutdown");
    }
}
