package com.ldq.study.thread.synchroniz;

public class TwoObjectLock implements Runnable {
    static TwoObjectLock twoObjectLock = new TwoObjectLock();
    Object lock1 = new Object();
    Object lock2 = new Object();

    @Override
    public void run() {
        /**
         * 两种不同的对象的锁
         */
      synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + " 获得lock1， now = " + System.currentTimeMillis());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "线程运行结束");
        }

        synchronized (lock2) {
            System.out.println(Thread.currentThread().getName() + " 获得lock2， now = " + System.currentTimeMillis());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "线程运行结束");
        }
    }

    /**
     * 所有线程都获取锁lock1，
     * 一个线程拿到lock1，其他所有线程都会被阻塞，
     * 当lock1释放后，两个线程同时获取锁，
     * 由于再次获取的是不同的锁，可以并发执行
     */
    public static void testCode() {
        Thread thread1 = new Thread(twoObjectLock);
        Thread thread2 = new Thread(twoObjectLock);
        thread1.start();
        thread2.start();
        while (thread1.isAlive() || thread2.isAlive()) {

        }

        System.out.println("code stop");

    }

    public static void main(String[] args) {
        testCode();
    }
}
