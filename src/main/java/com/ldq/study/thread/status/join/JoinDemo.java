package com.ldq.study.thread.status.join;

import java.util.concurrent.TimeUnit;

public class JoinDemo implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start to run");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " end1");
    }

    /**
     * 没有调用join方法，主线程会直接运行
     */
    public static void testNoJoin() {
        JoinDemo joinDemo = new JoinDemo();
        Thread thread = new Thread(joinDemo);

        thread.start();
        System.out.println("main is running");
    }

    /**
     * 调用join方法后，主线程将会等待thread线程完成后，才会继续运行
     *
     * @throws InterruptedException
     */
    public static void testJoin() throws InterruptedException {
        JoinDemo joinDemo = new JoinDemo();
        Thread thread = new Thread(joinDemo);

        thread.start();
        thread.join();
        System.out.println("main is running");
    }

    /**
     * 调用join方法后，同时指定时间，
     * 主线程将会等待thread线程运行指定时间
     * 才会立刻运行
     *
     * @throws InterruptedException
     */
    public static void testJoinTime() throws InterruptedException {
        JoinDemo joinDemo = new JoinDemo();
        Thread thread = new Thread(joinDemo);

        thread.start();
        thread.join(3 * 1000);
        System.out.println("main is running");
        //避免影响其他方法测试
        TimeUnit.SECONDS.sleep(4);
    }


    public static void main(String[] args) throws InterruptedException {
        testJoinTime();
        System.out.println("++++++++++++++");
        testJoin();
        System.out.println("==============");
        testNoJoin();
    }
}
