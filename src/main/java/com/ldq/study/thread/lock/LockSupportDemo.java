package com.ldq.study.thread.lock;

import org.junit.Test;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {


    public static void parkBeforeUnPark() {

        Thread thread = new Thread(() -> {
            System.out.println(new Date() + ": " + Thread.currentThread().getName() + " begin park");
            LockSupport.park();
            System.out.println(new Date() + ": " + Thread.currentThread().getName() + " stop park");
        });
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(new Date() + ": " + thread.getName() + " unpark");
        LockSupport.unpark(thread);
    }

    public static void unParkBeforePark() {

        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(new Date() + ": " + Thread.currentThread().getName() + " begin park");
            LockSupport.park();
            System.out.println(new Date() + ": " + Thread.currentThread().getName() + " stop park");
        });
        System.out.println(new Date() + ": " + thread.getName() + " unpark");
        thread.start();
        LockSupport.unpark(thread);
        System.out.println(new Date() + ": " + thread.getName() + " finish");

    }

    public static void main(String[] args) {
//        LockSupportDemo.unParkBeforePark();
        LockSupportDemo.parkBeforeUnPark();
    }

}
