package com.ldq.study.thread.status.stop;


import java.util.concurrent.TimeUnit;

public class StopFlag extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            System.out.println(this.getName() + "--" + i);
            try {
                if (this.isInterrupted()) {
                    System.out.println("thread first  interrupted? " + this.interrupted());
                    System.out.println("thread second interrupted? " + this.interrupted());

                    System.out.println("check interrupted");
                    break;
                }
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("thead done!");
    }

    public static void main(String[] args) throws InterruptedException {
        testFlag();
    }

    private static void testFlag() throws InterruptedException {
        Thread thread = new StopFlag();
        thread.start();
        thread.interrupt();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("thead is alive?" + thread.isAlive());
    }
}