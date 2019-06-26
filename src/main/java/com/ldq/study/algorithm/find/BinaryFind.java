package com.ldq.study.algorithm.find;

public class BinaryFind {

    /**
     * 常规版的二分查找包含bug，主要是在计算二分index的位置
     * 在 left 和 right 很大的时候，会出现溢出的情况，从而导致数组访问出错
     *
     * @param arrays
     * @param target
     * @return 数组中target值所在的位置
     */
    public static int binaryNormal(int[] arrays, int target) {
        int index = -1;
        int left = 0, right = arrays.length - 1;
        int middle;

        while (left <= right) {
            //计算二分index位置
            middle = (left + right) / 2;
            System.out.println("left = " + left + ",right = " + right);

            if (arrays[middle] < target) {
                //查找的值在目标值的左边，需要将搜索区间移动到较大端
                left = middle + 1;
            } else if (arrays[middle] > target) {
                //查找的值在目标值的右边，需要将搜索区间移动到较小端
                right = middle - 1;
            } else {
                //说明已经找到target值所在的index
                return middle;
            }
        }

        return index;
    }

    /**
     * 修复版将index计算方法变更为安全的方式
     *
     * @param arrays
     * @param target
     * @return 数组中target值所在的位置
     */
    public static int binaryFixBug(int[] arrays, int target) {
        int index = -1;
        int left = 0, right = arrays.length - 1;
        int middle;

        while (left <= right) {
            //将两者相加变为起点 + 递增区间的方式得到index
            middle = left + (right - left) / 2;
            System.out.println("left = " + left + ",right = " + right);

            if (arrays[middle] < target) {
                left = middle + 1;
            } else if (arrays[middle] > target) {
                right = middle - 1;
            } else {
                return middle;
            }
        }

        return index;
    }

    /**
     * 使用位运算代替除法运算，提高计算效率
     *
     * @param arrays
     * @param target
     * @return 数组中target值所在的位置
     */
    public static int binaryWithCool(int[] arrays, int target) {
        int index = -1;
        int left = 0, right = arrays.length - 1;
        int middle;

        while (left <= right) {
            //使用位运算，位运算优先级较低，需要括号保证优先级
            middle = left + ((right - left) >>> 1);
            System.out.println("left = " + left + ",right = " + right);

            if (arrays[middle] < target) {
                left = middle + 1;
            } else if (arrays[middle] > target) {
                right = middle - 1;
            } else {
                return middle;
            }
        }

        return index;
    }

}
