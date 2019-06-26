package com.ldq.study.algorithm.sort;

import java.util.Arrays;

public class InsertSort {
    /**
     * 每一轮排序，默认前面部分已经完成排序，只需要把当前位置的数据插入到正确位置即可
     * 逐步与前一个比较，交换位置
     * 稳定排序
     *
     * @param nums
     */
    public static void insertSort(int[] nums) {
        int[] arrays = Arrays.copyOf(nums, nums.length);
        int len = arrays.length;
        int j, temp;
        for (int i = 1; i < len; i++) {
            j = i;
            temp = arrays[i];
            while (j > 0 && temp < arrays[j - 1]) {
                arrays[j] = arrays[j - 1];
                j--;
            }

            if (j != i) {
                arrays[j] = temp;
            }

        }

        System.out.println(Arrays.toString(arrays));
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8, 1, 2, 3, 4, 5, 6, 7, 0};
        insertSort(nums);
    }
}
