package com.ldq.study.thread.tool;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void threadDemo1(){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

        Thread thread1 = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("A name = " + Thread.currentThread().getName());
                    Thread.sleep(1000);
                }
                cyclicBarrier.await();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is await");

        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        System.out.println("B name = " + Thread.currentThread().getName());
                        Thread.sleep(1000);
                    }
                    cyclicBarrier.await();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " is await too!");

            }
        });

        thread1.start();
        thread2.start();
        System.out.println("this is main thread!");

    }

    public static void runnableDemo(){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2,
                () -> System.out.println("stop thread = " + Thread.currentThread().getName()));

        Thread thread1 = new Thread(() -> {
            try {
                System.out.println("start thread " + Thread.currentThread().getName());
                for (int i = 0; i < 10; i++) {
                    System.out.println("working thread name = " + Thread.currentThread().getName());
                    Thread.sleep(1000);
                }
                    cyclicBarrier.await();

                System.out.println("waiting another thread");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is running");

        });

        Thread thread2 = new Thread(() -> {
            try {
                System.out.println("start thread " + Thread.currentThread().getName());
                for (int i = 0; i < 5; i++) {
                    System.out.println("working thread name = " + Thread.currentThread().getName());
                    Thread.sleep(1000);
                }
                    cyclicBarrier.await();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is running");

        });

        thread1.start();
        thread2.start();
        System.out.println("this is main thread!");
    }

    public static void main(String[] args) {
        threadDemo1();
        runnableDemo();

/*
*  阻塞子线程
* 计数器剋使用reset方法
* 可以循环使用
*
* 构造方法有两个，
*
* runnable类型，目的是当现成的拦截数量与构造方法的参数相同时，
* 有限执行构造方法里的任务，然后在执行每个线程中await方法后面的代码
*
*
* */

    }
}
