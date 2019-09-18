package com.ldq.study.algorithm.leetcode;

import java.rmi.Remote;
import java.util.ArrayList;
import java.util.HashMap;

import com.sun.org.apache.regexp.internal.RE;
import scala.Int;

public class Fibonacci {

    /**
     * 基础递归的方法
     * f(n) = f(n-1)+ f(n-2)
     *
     * @param num
     * @return
     */
    public static int f1(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("输入参数小于0");
        }
        if (num == 0 || num == 1) {
            return 1;
        }
        return f1(num - 1) + f1(num - 2);
    }

    /**
     * 递归+hashmap缓存
     * 利用hashmap实现缓存，O(1)的提取速度
     * map中的key和value都是Integer和Long类型，会有大量的自从拆装箱的性能问题
     * 而且自动拆装箱会创建中间对象，增加GC压力
     */
    static HashMap<Integer, Long> map = new HashMap<Integer, Long>();

    public static long f2(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("输入参数小于0");
        }
        if (num == 0 || num == 1) {
            return 1;
        }
        if (!map.containsKey(num)) {
            map.put(num, f2(num - 1) + f2(num - 2));
        }

        return map.get(num);
    }


    /**
     * 递归+数组缓存
     * 解决map的性能问题，利用数组就可以实现缓存
     * 递归容易出现递归深度较深，而报错的情况
     */
    static long[] mArray = new long[10000 + 1];

    public static long f3(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("输入参数小于0");
        }
        if (num == 0 || num == 1) {
            return mArray[num] = 1;
        }
        if (mArray[num] == 0) {
            mArray[num] = f3(num - 1) + f3(num - 2);
        }

        return mArray[num];
    }

    /**
     * 数组缓存+顺序递推
     * 由于递归有深度限制，因此，改用顺序递推的方式
     *
     * @param num
     * @return
     */
    public static long f4(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("输入参数小于0");
        }
        if (num == 0 || num == 1) {
            return 1;
        }

        long temp[] = new long[num + 1];
        temp[0] = 1;
        temp[1] = 1;
        for (int i = 2; i <= num; i++) {
            temp[i] = temp[i - 1] + temp[i - 2];
        }

        return temp[num];
    }

    /**
     * 由于顺序递推，因此不需要申请多余数组空间
     *
     * @param num
     * @return
     */
    public static long f5(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("输入参数小于0");
        }
        if (num == 0 || num == 1) {
            return 1;
        }

        long first = 1;
        long second = 1;
        long third = 0;
        for (int i = 2; i <= num; i++) {
            third = first + second;
            first = second;
            second = third;
        }

        return third;
    }

    /**
     * 数据公式法
     * 计算速度最快
     * 但是会丢失精度
     *
     * @param num
     * @return
     */
    public static long f6(int num) {
        double result;
        double base = 5.0;
        double temp = Math.sqrt(base);
        result = (Math.pow((1 + temp) / 2, num + 1) - Math.pow((1 - temp) / 2, num + 1)) / temp;
        return (long) result;
    }

    /**
     * 矩阵解法
     */
    static long[][] initMatirx = {{1, 1}, {1, 0}};

    public static long f7(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("输入参数小于0");
        }
        if (num == 0 || num == 1) {
            return 1;
        }
        long[][] temp = initMatirx;
        for (int i = 1; i < num - 1; i++) {
            temp = matirxMult(temp, initMatirx);
        }
        return temp[0][0] + temp[0][1];
    }

    private static long[][] matirxMult(long[][] a, long[][] b) {
        long[][] temp = new long[2][2];
        temp[0][0] = a[0][0] * b[0][0] + a[0][1] * b[1][0];
        temp[0][1] = a[0][0] * b[0][1] + a[0][1] * b[1][1];
        temp[1][0] = a[1][0] * b[0][0] + a[1][1] * b[1][0];
        temp[1][1] = a[1][0] * b[0][1] + a[1][1] * b[1][1];
        return temp;
    }

    /**
     * 矩阵解法+快速幂
     * 优化计算速度
     */
    static long[][] unitMatirx = {{1, 0}, {0, 1}};
    public static long f8(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("输入参数小于0");
        }
        if (num == 0 || num == 1) {
            return 1;
        }
        long[][] result = unitMatirx;
        long[][] temp = initMatirx;
        int m = num - 1;
        while (m != 0) {
            if ((m & 1) == 1) {
                result = matirxMult(temp, result);
            }
            temp = matirxMult(temp, temp);
            m >>= 1;
        }
        return result[0][0] + result[0][1];
    }

    public static void main(String[] args) {

        int num = 10;
        System.out.println(f1(num));
        System.out.println(f2(num));
        System.out.println(f3(num));
        System.out.println(f4(num));
        System.out.println(f5(num));
        System.out.println(f6(num));
        System.out.println(f7(num));
        System.out.println(f8(num));
    }
}
