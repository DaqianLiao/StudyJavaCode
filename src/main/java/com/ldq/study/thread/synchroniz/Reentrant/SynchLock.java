package com.ldq.study.thread.synchroniz.Reentrant;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchLock {
    Lock lock = new ReentrantLock();

    public synchronized void method1() {
        System.out.println("Im synchronized method");
    }

    public void method2() {
        lock.lock();
        try {
            System.out.println("Im lock method");
        } finally {
            lock.unlock();
        }
    }


    /**
     * 以上两个方法的锁形式是等价的
     * 也就是synchronized可以表达为lock的形式
     *
     * @param args
     */
    public static void main(String[] args) {
        SynchLock synchLock = new SynchLock();
        synchLock.method1();
        synchLock.method2();

    }
}
