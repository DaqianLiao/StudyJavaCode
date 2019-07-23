package com.ldq.study.thread.status.stop;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Stop implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Im running! times = " + i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thead is done!");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Stop());
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(5));
            System.out.println("preparing to stop thead!");
            thread.stop();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
