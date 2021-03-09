package com.ldq.study.util;

import java.util.Random;

public class ZkBucketSession {
    final static long expirationInterval = 3000;
    private static long roundToNextInterval(long time) {
        return (time / expirationInterval + 1) * expirationInterval;
    }

    public static void main(String[] args) throws InterruptedException {
        int time = 10;
        long bucket,now;
        for (int i = 0; i < time; i++) {
             now = System.nanoTime()/1000000;
            bucket = roundToNextInterval(now);
            Thread.sleep(new Random().nextInt(30)*100);
            System.out.println("time  = " + now + ", bucket  = " + bucket);
        }
    }
}
