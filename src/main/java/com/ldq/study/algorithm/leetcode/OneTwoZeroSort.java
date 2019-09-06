package com.ldq.study.algorithm.leetcode;

import java.util.Arrays;

public class OneTwoZeroSort {

    /**
     * 分别统计0，1，2的数据个数
     * 然后在按照顺序分别将0，1，2添加到新数组中
     *
     * @param num
     */
    public static void countSort(int[] num) {
        int length = num.length;
        int[] counts = new int[3];
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            counts[num[i]]++;
        }
        System.out.println("分别统计0，1，2对应的数据的个数：" + Arrays.toString(counts));

//        /**
//         * 常规写法
//         */
//        for (int i = 0; i < counts[0]; i++) {
//            result[i] = 0;
//        }
//        for (int i = counts[0]; i < counts[0] + counts[1]; i++) {
//            result[i] = 1;
//        }
//        for (int i = counts[0] + counts[1]; i < length; i++) {
//            result[i] = 2;
//        }

        /**
         * 优化后的写法，将数组的索引index独立自增
         */
        int index = 0;
        for (int i = 0; i < counts[0]; i++) {
            result[index++] = 0;
        }
        for (int i = 0; i < counts[1]; i++) {
            result[index++] = 1;
        }
        for (int i = 0; i < counts[2]; i++) {
            result[index++] = 2;
        }
        System.out.println(Arrays.toString(result));
    }

    /**
     * a[0-zero] = 0
     * a[zero-two] = 1
     * a[two-n-1] = 2
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     * @param num
     */
    public static void mergeSort(int[] num) {
        int length = num.length;
        int zero = -1; //nums[0,zero] = 0
        int two = length; //nums[two,n-1] = 2
        int temp;

        for (int i = 0; i < two; ) {
            System.out.println("第" + i + "个元素：" + num[i]);

            if (num[i] == 1) {
                /**
                 * 如果当前数为1，不用移动，直接判断下一个数据
                 * i其实对应的是1的下标
                 */
                i++;
            } else if (num[i] == 2) {
                /**
                 * 如果当前数据为2，将其和尾部数据交换
                 * 由于交换后，i这个数据不知道是多少，
                 * 所以需要重新判断一次i，因此不需要对i++
                 */
                temp = num[i];
                num[i] = num[--two];
                num[two] = temp;
            } else {
                /**
                 * 数据是0，则必定是在0和1之间交换
                 * 因此将0交换到头部，同时i++
                 */
                temp = num[i];
                num[i++] = num[++zero];
                num[zero] = temp;

            }
            System.out.println(Arrays.toString(num));
        }

        System.out.println(Arrays.toString(num));

    }


    public static void main(String[] args) {
        int[] num = {0, 1, 2, 0, 2, 2, 1, 1, 1, 0, 2, 2, 2, 0, 0};
        countSort(num);
        System.out.println("==========================");
        mergeSort(num);
    }
}
