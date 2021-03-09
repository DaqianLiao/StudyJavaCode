package com.ldq.study.gc.malloc;

import java.util.concurrent.TimeUnit;

public class testG1Allocation {
    private static final int _1MB = 1024 * 1024;

    /**
     * VM参数：-verbose:gc -Xms20M -Xmx20M -XX:+PrintGCDetails -XX:+UseG1GC
     */
    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        byte[] allocation5, allocation6;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];  // 出现一次Minor GC


        try {
            TimeUnit.SECONDS.sleep(2);
            System.gc();

            System.out.println("===============================");
            allocation5 = new byte[1 * _1MB];
            allocation6 = new byte[1 * _1MB];
            TimeUnit.SECONDS.sleep(4);
            System.gc();
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        testAllocation();
    }
}
