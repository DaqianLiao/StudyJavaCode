package com.ldq.study.thread.synchroniz;

public class TwoClassLock implements Runnable {
    static TwoClassLock twoClassLock = new TwoClassLock();

    @Override
    public void run() {
        /**
         * 类锁的静态方法
         *
         */
        print();
        otherPrint();
    }

    public static synchronized void print() {
        System.out.println(Thread.currentThread().getName() + " 获得class lock，" +
                "now = " + System.currentTimeMillis());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "线程运行结束");
    }

    /**
     * 与SyncThread2对比，可以发现，不同的对象锁之间，可以并行
     * 类锁则只允许同时只有一个线程运行
     */
    public static synchronized void otherPrint() {
        System.out.println(Thread.currentThread().getName() + " 获得class lock，other print!" +
                " now = " + System.currentTimeMillis());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "线程运行结束");
    }


    /**
     * 所有线程都尝试获取类锁，
     * 一个线程拿到类锁，其他所有线程都会被阻塞
     */
    public static void testCode() {
        Thread thread1 = new Thread(twoClassLock);
        Thread thread2 = new Thread(twoClassLock);
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
