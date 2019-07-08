package com.ldq.study.thread.printChange;

/**
 * 线程切换明显减少，由于不满足打印条件，
 * 就先唤醒其他线程，然后自己阻塞
 */
public class WaitNotifyThread {

    static int maxInt = 100;
    static volatile int index = 0;
    static volatile boolean flag = true;
    static Object lock = new Object();

    static class MyRun1 implements Runnable {

        @Override
        public void run() {
            while (index < maxInt) {
                System.out.println(Thread.currentThread().getName() +
                        " is ready to run! now flag = " + flag + ", index = " + index);
//                由于是同一个对象，因此两个线程只允许又一个拿到锁
                synchronized (lock) {
                    if (flag) {
                        System.out.println(Thread.currentThread().getName() + " is print:" + index++);
                        flag = false;
                    } else {
//                        唤醒被阻塞的线程
                        lock.notifyAll();
                        try {
//                            阻塞当前线程，打印结束条件，不再加锁
                            if (index + 1 < maxInt) {
                                lock.wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            System.out.println(Thread.currentThread().getName() + " stop thread! index =" + index);
        }
    }

    static class MyRun2 implements Runnable {

        @Override
        public void run() {
            while (index < maxInt) {
                System.out.println(Thread.currentThread().getName() +
                        " is ready to run! now flag = " + flag + ", index = " + index);

//                由于是同一个对象，因此两个线程只允许又一个拿到锁
                synchronized (lock) {
                    if (!flag) {
                        System.out.println(Thread.currentThread().getName() + " is print:" + index++);
                        flag = true;
                    } else {
//                        唤醒被阻塞的线程
                        lock.notifyAll();
                        try {
//                            阻塞当前线程，打印结束条件，不再加锁
                            if (index + 1 < maxInt) {
                                lock.wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            System.out.println(Thread.currentThread().getName() + " stop thread! index =" + index);
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRun1());
        Thread t2 = new Thread(new MyRun2());
        t1.start();
        t2.start();
    }

}
