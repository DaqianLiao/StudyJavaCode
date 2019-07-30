package com.ldq.study.base;


/**
 * 当两个超过int最大值范围的数相加，会出现溢出现象
 */
public class LargeIntSum {
    public static void outOfInt() {
        int i = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;
        int k = i + j;
        System.out.println("j = " + j + ", i = " + i);
        System.out.println("k = " + k);
        System.out.println("Integer.toBinaryString(k) = " + Integer.toBinaryString(k));
    }

    /**
     * 通常用来求中点的下标时，容易出现这种情况，需要避免
     * 可以使用middle的方式来计算
     */
    public static void update() {
        int low = Integer.MAX_VALUE - 100;
        int high = Integer.MAX_VALUE - 10;

        int error = (low + high) / 2;
        int middle = low + (high - low) / 2;
        System.out.println("error = " + error);
        System.out.println("middle = " + middle);
    }

    public static void main(String[] args) {
        outOfInt();
        update();
    }
}
