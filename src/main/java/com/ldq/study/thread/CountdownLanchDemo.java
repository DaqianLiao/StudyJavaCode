package com.ldq.study.thread;

import java.util.concurrent.CountDownLatch;

public class CountdownLanchDemo {

    /*
    * 阻塞主线程
    * 计数器只能使用一次
    *
    */
    public static void thread() throws InterruptedException {
        CountDownLatch countdownLanch = new CountDownLatch(2);

        Thread thread1 = new Thread(() -> {
            try {
                System.out.println("A name = " + Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is countDown");
            countdownLanch.countDown();
        });

        Thread thread2 = new Thread(() -> {
            try {
                System.out.println("B name = " + Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is countDown too");
            countdownLanch.countDown();
        });

        thread1.start();
        thread2.start();
        countdownLanch.await();
        System.out.println("this is main thread!");


    }

    public static void main(String[] args) throws InterruptedException {
       thread();
    }
}
