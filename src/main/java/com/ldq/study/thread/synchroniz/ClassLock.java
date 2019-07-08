package com.ldq.study.thread.synchroniz;

public class ClassLock implements Runnable {
    static ClassLock classLock = new ClassLock();

    @Override
    public void run() {
        /**
         * 类锁的同步代码块
         */
      synchronized (ClassLock.class) {
            System.out.println(Thread.currentThread().getName() + " 获得SyncThread3.class lock，" +
                    " now = " + System.currentTimeMillis());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "线程运行结束");
        }

    }


    /**
     * 所有线程都尝试获取类锁，
     * 一个线程拿到类锁，其他所有线程都会被阻塞
     *
     */
    public static void testCode() {
        Thread thread1 = new Thread(classLock);
        Thread thread2 = new Thread(classLock);
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
