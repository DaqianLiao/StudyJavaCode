package com.ldq.study.algorithm.sort;

import java.util.Arrays;

public class BubbleSort {

    /**
     * 每次比较前后两个数据的时候，大的数据靠后排
     * 时间复杂度：O(N^2)
     * 稳定排序
     *
     * @param nums
     * @return
     */
    public static int[] bubbleSort(int[] nums) {
        int[] arrays = Arrays.copyOf(nums, nums.length);
        int len = arrays.length;
        int temp;

        for (int i = 0; i < len - 1; i++) {

            for (int j = 0; j < len - 1 - i; j++) {
                if (arrays[j] > arrays[j + 1]) {
                    temp = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arrays));
        return arrays;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 0};
        bubbleSort(nums);
    }
}
