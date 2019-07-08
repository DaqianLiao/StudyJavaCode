package com.ldq.study.thread.synchroniz;

public class ObjectLock implements Runnable {
    static ObjectLock objectLock = new ObjectLock();

    @Override
    public void run() {
        /**
         * 两种对象锁的实现方式，
         */
        System.out.println(Thread.currentThread().getName() +" get this  = " + this);
        System.out.println(Thread.currentThread().getName() +" get twoClassLock  = " + objectLock);
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + "线程开始执行， now = " + System.currentTimeMillis());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "线程运行结束");
        }

        exe();
    }

    /**
     * 也是对象锁，用在普通方法上，锁住的对象是this
     */
    public synchronized void exe() {
        System.out.println(Thread.currentThread().getName() + "线程开始执行， now = " + System.currentTimeMillis());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "线程运行结束");
    }


    public static void testCode() {
        Thread thread1 = new Thread(objectLock);
        Thread thread2 = new Thread(objectLock);
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
