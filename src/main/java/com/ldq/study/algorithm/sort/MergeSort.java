package com.ldq.study.algorithm.sort;

import java.util.Arrays;

/**
 * 稳定排序
 * 空间复杂度：O(n)
 * 时间复杂度：O(nlgn)
 */
public class MergeSort {

    public static void mergeSort(int[] arrays, int left, int right) {
        //采用这个方式计算是避免数据溢出导致的问题
        int mid = left + (right - left) / 2;
        if (left < right) {
//            System.out.println("left = " + left + ", right = " + right);
            mergeSort(arrays, left, mid);
            mergeSort(arrays, mid + 1, right);

            merge(arrays, left, mid, right);

        }
    }

    public static void merge(int[] arrays, int left, int mid, int right) {
        System.out.println("left = " + left + ", mid = " + mid + ", right = " + right);
        int len = right - left + 1;
        int[] temp = new int[len];
        int i = left;
        int j = mid + 1;
        int index = 0;

        //对比两个子序列，按照大小顺序将元素添加到临时数组中
        while (i <= mid && j <= right) {
            System.out.println("left num = " + arrays[i] + ", right num = " + arrays[j]);
            if (arrays[i] < arrays[j]) {
                temp[index++] = arrays[i++];
            } else {
                temp[index++] = arrays[j++];
            }
        }
        //将左边数组中剩余的数据添加到临时数组中
        //优先添加左边，因为左边的数组比右边的数组中的元素小
        while (i <= mid) {
            temp[index++] = arrays[i++];
        }
        //将右边数组中的剩余元素添加到临时数组中
        while (j <= right) {
            temp[index++] = arrays[j++];
        }

        System.out.println("temp array = " + Arrays.toString(temp));
        for (int k = 0; k < temp.length; k++) {
            arrays[left + k] = temp[k];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8, 1, 2, 3, 4, 5, 6, 7, 0};
        mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}


