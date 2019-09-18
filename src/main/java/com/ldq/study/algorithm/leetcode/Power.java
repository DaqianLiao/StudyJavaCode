package com.ldq.study.algorithm.leetcode;


public class Power {

    public static long getResult(int num, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return num;
        }

        System.out.println("num = " + num + ", n = " + n);
        long result = getResult(num, n >> 1);
        System.out.println("result = " + result);
        result *= result;
        return (n & 1) == 1 ? num * result : result;
    }

    public static double pow(int num, int n) {
        if (n == 0) {
            return 0;
        }
        boolean isNegative = false;
        if (n < 0) {
            isNegative = true;
            n = -n;
        }

        double result = getResult(num, n);

        System.out.println("result = " + result);
        return isNegative ? 1 / result : result;
    }


    public static void main(String[] args) {
        System.out.println(pow(3, -1));
        System.out.println(pow(3, 1));
//        System.out.println(getResult(2, 4));
    }
}