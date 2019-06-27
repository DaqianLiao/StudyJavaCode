package com.ldq.study.algorithm.sort;

import java.util.Arrays;

/**
 * 使用分治法
 * 先找到基准值，遍历数组，将数组左边大于基准值的数据和右边大于基准值的数据进行交换
 * 从而达到，将基准值优先排序，在分别对两边的子序列执行同样的操作
 * 稳定排序
 * 空间复杂度：O(logn)
 * 时间复杂度：最坏情况：O(n^2)
 * 平均情况：O(nlogn)
 */
public class QuickSort {
    public static void sort(int[] arrays, int left, int right) {
        if (left > right) {
            return;
        }

        int leftIndex = left;
        int rightIndex = right;
//        确定基准值
        int flag = arrays[left];
        int temp;
        while (leftIndex < rightIndex) {

//            从右往左找到第一个小于基准值的数
//            如果找不到，则右边的索引和左边的索引相等
            while (arrays[rightIndex] >= flag && leftIndex < rightIndex) {
                rightIndex--;
            }
//            从左往右找到第一个大于基准值的数
//            如果找不到，则右边的索引和左边的索引相等
            while (arrays[leftIndex] <= flag && leftIndex < rightIndex) {
                leftIndex++;
            }

            System.out.println("leftIndex = " + leftIndex + ", rightIndex = " + rightIndex);
//            左边的索引小于右边的索引时，表示符合条件，需要交换数据
            if (leftIndex < rightIndex) {
                temp = arrays[rightIndex];
                arrays[rightIndex] = arrays[leftIndex];
                arrays[leftIndex] = temp;
            }
        }

//        此时左右索引相同
        arrays[left] = arrays[leftIndex];
        arrays[leftIndex] = flag;
//        对左子列进行快排
        sort(arrays, left, leftIndex - 1);
//        对右子列进行快排
        sort(arrays, leftIndex + 1, right);

    }

    public static void main(String[] args) {
        int[] nums = new int[]{8, 1, 2, 3, 4, 5, 6, 7, 0};
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
