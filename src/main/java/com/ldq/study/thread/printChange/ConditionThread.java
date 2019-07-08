package com.ldq.study.thread.printChange;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程切换明显减少，由于不满足打印条件，
 * 就先唤醒其他线程，然后自己阻塞
 */
public class ConditionThread {

    static int maxInt = 100;
    static volatile int index = 0;
    static volatile boolean flag = true;
    static Lock lock = new ReentrantLock();
    static Condition singleNum = lock.newCondition();
    static Condition doubleNum = lock.newCondition();

    static class MyRun1 implements Runnable {

        @Override
        public void run() {

            while (index < maxInt) {
//                由于是同一个对象，因此两个线程只允许又一个拿到锁
                lock.lock();
                System.out.println(Thread.currentThread().getName() +
                        " is ready to run! now flag = " + flag + ", index = " + index);

                try {
                    //如果执行的是奇数打印
                    if (flag) {
//                        阻塞当前线程
                        singleNum.await();
                    }
                    System.out.println("flag = " + flag);
                    System.out.println(Thread.currentThread().getName() + " is print: " + index++);
                    flag = true;
                    Thread.sleep(10);
//                    唤醒打印偶数线程
                    doubleNum.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        }
    }

    static class MyRun2 implements Runnable {

        @Override
        public void run() {
            while (index < maxInt) {
//                由于是同一个对象，因此两个线程只允许又一个拿到锁
                lock.lock();
                System.out.println(Thread.currentThread().getName() +
                        " is ready to run! now flag = " + flag + ", index = " + index);

                try {
                    //如果执行的是偶数打印
                    if (!flag) {
                        doubleNum.await();
                    }

                    System.out.println("flag = " + flag);
                    System.out.println(Thread.currentThread().getName() + " is print: " + index++);
                    flag = false;
                    Thread.sleep(10);

                    singleNum.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRun1(), "t1");
        Thread t2 = new Thread(new MyRun2(), "t2");
        t1.start();
        t2.start();
    }

}
