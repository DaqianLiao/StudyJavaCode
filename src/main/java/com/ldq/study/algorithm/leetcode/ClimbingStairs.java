package com.ldq.study.algorithm.leetcode;

/**
 * 爬楼梯问题
 * 每次只能走1步或者2步
 * 爬到第N层楼梯有几种走法
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        int stairs = 4;
        System.out.println("递归版：" + climbing(stairs));
        System.out.println("动态规划版本：" + climbing1(stairs));
    }

    /**
     * 第n层楼梯 = 第n-1层楼梯 + 第n-2层楼梯的走法之和
     * 转化成斐波那契额
     * 递归的实现方法：
     * 缺点：当递归深度较深时，会报错
     *
     * @param stairs
     * @return
     */
    private static int climbing(int stairs) {
        if (stairs == 0 || stairs == 1) {
            return 1;
        }
        return climbing(stairs - 1) + climbing(stairs - 2);
    }

    /**
     * 动态规划版本：
     * 1、DP 状态定义
     * 2、DP状态方程
     * @param stairs
     * @return
     */
    private static int climbing1(int stairs) {
        int n = 1, n_1 = 1, n_2 = 1;
        if (stairs == 1) {
            return 1;
        }

        /**
         * f(n) = f(n-1) + f(n-2)
         * n = f(n), n_1 = f(n-1), n_2 = f(n_2)
         * 两种实现方式，
         *      第一种：使用数组记录所有数据，空间复杂度O(n)
         *      第二种：利用两个数据记录，需要对数据进行重新赋值，空间复杂度O(1)
         */
        for (int i = 2; i <= stairs; i++) {
            n = n_1 + n_2;
            n_2 = n_1;
            n_1 = n;
        }
        return n;
    }


}
