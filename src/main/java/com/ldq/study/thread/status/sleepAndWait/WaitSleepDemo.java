package com.ldq.study.thread.status.sleepAndWait;

import java.util.concurrent.TimeUnit;

public class WaitSleepDemo {
    /**
     * Thread A is waiting to get lock!
     * Thread A get lock! // 获取锁后，sleep了2秒
     * Thread B is waiting to get lock!
     * Thread A is done  // 由于sleep并没有释放锁，所以，ThreadA线程完成所有任务
     * Thread B get lock! //ThreadB线程必须等到ThreadA线程释放锁，才能获取到锁资源
     * Thread B is done
     */
    public static void test1() {
        Object lock = new Object();
        new Thread(() -> {
            System.out.println("Thread A is waiting to get lock!");
            synchronized (lock) {
                System.out.println("Thread A get lock!");
                try {
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("Thread A is done");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            System.out.println("Thread B is waiting to get lock!");
            synchronized (lock) {
                System.out.println("Thread B get lock!");
                try {
                    lock.wait(1000);
                    System.out.println("Thread B is done");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * Thread A is waiting to get lock!
     * Thread A get lock! //wait 此时释放了锁，并且等待了1秒
     * Thread B is waiting to get lock!
     * Thread B get lock! //由于ThreadA 释放了锁，所以ThreadB才能获取到锁
     * Thread B is done
     * Thread A is done
     */
    public static void test2() {
        Object lock = new Object();
        new Thread(() -> {
            System.out.println("Thread A is waiting to get lock!");
            synchronized (lock) {
                System.out.println("Thread A get lock!");
                try {
                    lock.wait(1000);
                    System.out.println("Thread A is done");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            System.out.println("Thread B is waiting to get lock!");
            synchronized (lock) {
                System.out.println("Thread B get lock!");
                try {
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("Thread B is done");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        //两个方法每次运行其中一个
        test1();
//        test2();
    }
}
