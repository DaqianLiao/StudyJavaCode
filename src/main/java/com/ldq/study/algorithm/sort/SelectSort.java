package com.ldq.study.algorithm.sort;

import java.util.Arrays;

public class SelectSort {
    /**
     * 每一轮排序，都会选择剩余数组中最小的值和每轮开头位置调换
     * 直到轮询完成，排序完成
     * 稳定排序
     *
     * @param nums
     */
    public static void selectSort(int[] nums) {
        int[] arrays = Arrays.copyOf(nums, nums.length);
        int len = arrays.length;
        int index, temp;
        for (int i = 0; i < len; i++) {
            index = i;
            for (int j = i + 1; j < len; j++) {
                System.out.println("a1 = " + arrays[i] + ", a2 = " + arrays[j]);
                if (arrays[j] < arrays[index]) { //找到每一轮中最小的数
                    index = j; //保存最小数值的索引
                }
            }
            if (index > i) {
                System.out.println("need change: " + "a1 = " + arrays[i] + ", a2 = " + arrays[index]);
                temp = arrays[i];
                arrays[i] = arrays[index];
                arrays[index] = temp;
            }

        }

        System.out.println(Arrays.toString(arrays));

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 0};
        selectSort(nums);
    }
}
