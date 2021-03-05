package com.ldq.study.algorithm.sort;

import java.util.Arrays;
//插入排序算法
public class InsertSort {
    /**
     * 每一轮排序，默认前面部分已经完成排序，只需要把当前位置的数据插入到正确位置即可
     * 逐步与前一个比较，交换位置
     * 稳定排序
     * 时间复杂度O(N)，最坏情况O(N^2)
     * @param nums
     */
    public static void insertSort(int[] nums) {
//        将nums数组内容复制给arrays
        int[] arrays = Arrays.copyOf(nums, nums.length);
//        计算数组长度
        int len = arrays.length;
//        j 为当前游标，temp为临时值，用来交换两个数
        int j, temp;
        for (int i = 1; i < len; i++) {
            j = i;
//            记录当前需要插入的值
            temp = arrays[i];
//            每次和前面的一位进行比较，如果当前值比前一个小，则互换，主要进行更换操作
            while (j > 0 && temp < arrays[j - 1]) {
                arrays[j] = arrays[j - 1];
                j--;
            }
//            如果不相等，表示当前值已经向前插入了，需要将新游标对应的值更新为当前排序值
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
