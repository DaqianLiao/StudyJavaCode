package com.ldq.study.algorithm.time;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class TimeWheel {


    CountDownLatch latch = new CountDownLatch(1);
    public static int normalizeTicksPerWheel(int ticksPerWheel) {
        int normalizedTicksPerWheel = 1;
        System.out.println("ticksPerWheel = " + ticksPerWheel);
        while (normalizedTicksPerWheel < ticksPerWheel) {
            System.out.println("before normalizedTicksPerWheel = " + normalizedTicksPerWheel);
            //每次向左移动一位，直到超过ticksPerWheel
            normalizedTicksPerWheel <<= 1;
            System.out.println("after normalizedTicksPerWheel = " + normalizedTicksPerWheel);
            System.out.println("----------------------------");
        }
        System.out.println("final normalizedTicksPerWheel = " + normalizedTicksPerWheel);
        return normalizedTicksPerWheel;
    }

    public static void main(String[] args) {
        normalizeTicksPerWheel(5);
    }

}
