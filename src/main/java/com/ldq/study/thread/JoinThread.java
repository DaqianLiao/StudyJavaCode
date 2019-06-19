package com.ldq.study.thread;

public class JoinThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            try {
                System.out.println("A name = " + Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is countDown");

        });

        Thread thread2 = new Thread(() -> {
            try {
                System.out.println("B name = " + Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is countDown");

        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("this is main thread!");

    }
}
