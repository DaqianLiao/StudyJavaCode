package com.ldq.study.algorithm.leetcode;

/**
 * 判断一个无符号为数字有多少个1
 * 3:  011 -> 2
 * 5:  101 -> 2
 * 8: 1000 -> 1
 */
public class HammingWeight {

    public static void main(String[] args) {

        int num = 5;
        System.out.println(humming(num));
        System.out.println(humming1(num));
    }

    /**
     *  x & (x-1)
     *  这个计算公式就是不断的消除x二进制数字最后一个1
     *  & 两个都为1，才是1
     * @param num
     * @return
     */
    private static int humming1(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num = num & (num - 1);
        }
        return count;
    }

    /**
     * 转化为2进制，不断右移判断最后一位是否为1
     *
     * @param num
     */
    private static int humming(int num) {
        int count = 0;
        while (num != 0) {
            if (num % 2 == 1) {
                count++;
            }
            num = num >> 1;
        }
        return count;
    }


}
