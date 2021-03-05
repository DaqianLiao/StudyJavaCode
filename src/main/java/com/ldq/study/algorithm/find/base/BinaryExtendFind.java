package com.ldq.study.algorithm.find.base;

/**
 * 主要是各种二分查找的扩展版本
 */
public class BinaryExtendFind {
    static int[] array = {1, 1, 1, 2, 4, 5, 5, 6, 8, 8};
    static int[] index = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    /**
     * 查找第一个=key的数
     * <p>
     * 关键条件：当middle对应的值和key相等时，依然进行下一步查找
     * 当有相等的数，右边相等的值会忽略，继续查找
     * 当左右位置指针相等时，依然进行查找，右指针-1或者左指针+1，跳出循环
     * 此时需要对左指针判断是否越界
     *
     * @param array
     * @param key
     * @return
     */
    public static int findFirstEqual(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            System.out.print("left = " + left);
            System.out.print("\t mid = " + mid);
            System.out.println("\t right = " + right);
            //Key Condition
            if (array[mid] >= key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        /**
         * condition1 && Condition2
         * condition1 条件约束：
         * 当查找的数在最右边，且不存在时，左指针的值会越界从而返回-1
         * condition2 条件约束：
         * 当查找到数组中位数退出while循环，此时需要判断中位值是否等于key
         */
        if (left < array.length && array[left] == key) {
            return left;
        }
        return -1;

    }

    /**
     * 查找最后一个=key的数
     * <p>
     * 关键条件：当middle对应的值和key相等时，依然进行下一步查找
     * 当有相等的数，左边相等的值会忽略，继续查找
     * 当左右位置指针相等时，依然进行查找，右指针-1或者左指针+1，跳出循环
     * 此时需要对右指针判断是否越界
     *
     * @param array
     * @param key
     * @return
     */
    public static int findLastEqual(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            System.out.print("left = " + left);
            System.out.print("\t mid = " + mid);
            System.out.println("\t right = " + right);
            //Key Condition
            if (array[mid] <= key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        //当查找的数在最左边，且不存在时，右指针的值会越界（right = -1）从而返回
        if (right >= 0 && array[right] == key) {
            return right;
        }
        return -1;
    }

    /**
     * 查找第一个>key的数
     *
     * @param array
     * @param key
     * @return
     */
    public static int findFirstLarger(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            System.out.print("left = " + left);
            System.out.print("\t mid = " + mid);
            System.out.println("\t right = " + right);
            //Key Condition
            if (array[mid] > key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        /**
         * 当查找的数在最右边
         *  不存在时，左指针的值会越界从而返回-1
         *  由于左边比key小的数都会让循环继续
         *
         */
        if (left < array.length) {
            return left;
        }
        return -1;

    }

    /**
     * 查找第一个>=key的数
     *
     * @param array
     * @param key
     * @return
     */
    public static int findFirstEqualLarger(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            System.out.print("left = " + left);
            System.out.print("\t mid = " + mid);
            System.out.println("\t right = " + right);
            //Key Condition
            if (array[mid] >= key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        /**
         * 当查找的数在最右边
         *  不存在时，左指针的值会越界从而返回-1
         *  由于左边比key小的数都会让循环继续
         *
         */
        if (left < array.length) {
            return left;
        }

        return -1;
    }

    /**
     * 查找第一个 < key 的数
     *
     * @param array
     * @param key
     * @return
     */
    public static int findFirstSmall(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            System.out.print("left = " + left);
            System.out.print("\t mid = " + mid);
            System.out.println("\t right = " + right);
            //Key Condition
            if (array[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (right >= 0) {
            return right;
        }
        return -1;
    }

    /**
     * 查找第一个 <= key 的数
     *
     * @param array
     * @param key
     * @return
     */
    public static int findFirstEqualSmall(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            System.out.print("left = " + left);
            System.out.print("\t mid = " + mid);
            System.out.println("\t right = " + right);
            //Key Condition
            if (array[mid] <= key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (right >= 0) {
            return right;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("array length = " + array.length);
//        System.out.println("index = " + findFirstEqual(array, 1));
//        System.out.println("index = " + findFirstEqual(array, 5));
//        System.out.println("index = " + findFirstEqual(array, 8));
//        System.out.println("index = " + findFirstEqual(array, 10));
//
//
//        System.out.println("index = " + findLastEqual(array, 1));
        System.out.println("index = " + findFirstEqualLarger(array, 6));
//        System.out.println("index = " + findFirstEqualLarger(array, 10));
//
//        System.out.println("index = " + findFirstLarger(array, 4));
//        System.out.println("index = " + findFirstLarger(array, 8));
//
//
//        System.out.println("index = " + findFirstSmall(array, 10));
//        System.out.println("index = " + findFirstSmall(array, 8));
//
//        System.out.println("index = " + findFirstEqualSmall(array, 10));
//        System.out.println("index = " + findFirstEqualSmall(array, 8));
//        System.out.println("index = " + findFirstEqualSmall(array, 3));
//        System.out.println("index = " + findFirstEqualSmall(array, 0));


    }
}
