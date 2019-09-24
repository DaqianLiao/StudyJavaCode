package com.ldq.study.algorithm.leetcode;

/**
 * 求两块夹板之间的最大水位：
 * 其实就是求两个夹板最小值与底边的乘积最大值
 * 解法：双指针
 * 时间复杂度:O(n)
 * 空间复杂度:O(1)
 */
public class MaxWater {

    public static void main(String[] args) {
        int[] array = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("max water = " + maxWater(array));
    }

    private static int maxWater(int[] array) {
        /**
         * 判断array是否长度为2
         * 其实还需要判断数组中的值是否都大于0
         * 默认符合规范
         */
        if (array.length < 2) {
            return -1;
        }
        int i = 0, j = array.length - 1, res = 0;
        while (i < j) {
            res = array[i] < array[j] ? Math.max(res, (j - i) * array[i++]) : Math.max(res, (j - i) * array[j--]);
        }

        return res;
    }
}
