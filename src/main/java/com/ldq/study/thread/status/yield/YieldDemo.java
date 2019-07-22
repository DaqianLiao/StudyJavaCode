package com.ldq.study.thread.status.yield;

import java.util.concurrent.TimeUnit;

public class YieldDemo {
    static class ThreadA implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "--" + i);
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "--" + i);
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
    }


    static class ThreadC implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "--" + i);
                try {
                    TimeUnit.MILLISECONDS.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Thread.yield();
            }
        }
    }

    static class ThreadD implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "--" + i);
                try {
                    TimeUnit.MILLISECONDS.sleep(300);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        testNoYield();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("=============");
        testYield();

    }

    /**
     * 线程执行了yield方法，会让出CPU资源，然后具有相同优先级的等待线程竞争执行权
     */
    private static void testYield() {
        Thread t1 = new Thread(new ThreadC());
        Thread t2 = new Thread(new ThreadD());
        t1.start();
        t2.start();
    }


    private static void testNoYield() {
        Thread t1 = new Thread(new ThreadA());
        Thread t2 = new Thread(new ThreadB());
        t1.start();
        t2.start();
    }
}
