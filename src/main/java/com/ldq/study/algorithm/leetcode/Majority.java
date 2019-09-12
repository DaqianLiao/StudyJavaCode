package com.ldq.study.algorithm.leetcode;

import java.util.Arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 求众数：
 * 众数：某个数出现的次数大于数组的N/2
 * 1、暴力
 * 2、计数
 * 3、先排序，后遍历
 * 4、分治，分别统计左右两边的majority数据，在比较次数大小
 */
public class Majority {

    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 1, 1, 2, 3};
        majorityBF(array);
        majorityMap(array);
        majoritySort(array);
    }

    /**
     * 先排序，后顺序计数
     * 时间复杂度：O(Nlog(N))
     * 空间复杂度：O(N)
     * @param array
     */
    private static void majoritySort(int[] array) {
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        int len = array.length;
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (array[i] == array[i - 1]) {
                if (++count > len / 2) {
                    System.out.println(array[i] + "出现了" + count + "次");
                }
            } else {
                count = 1;
            }

        }
    }

    /**
     * 计数统计法:
     * 将每个数和出现次数保存在一个map中
     * 每次统计的时候进行判断
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     *
     * @param array
     * @return
     */
    private static int majorityMap(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = array.length;
        int count;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(array[i])) {
                count = map.get(array[i]);
                map.put(array[i], ++count);
                if (count > len / 2) {
                    System.out.println(array[i] + "出现了" + count + "次");
                    return array[i];
                }
            } else {
                map.put(array[i], 1);
            }
        }
        System.out.println(map);
        return -1;
    }


    /**
     * 暴力求解法：
     * 两层循环：
     * 第一层：获取数组中的每个数
     * 第二层：再次遍历数组，找到和这个数相同的数，并记录出现次数
     * 如果找到众数，就返回
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     *
     * @param array
     * @return
     */
    private static int majorityBF(int[] array) {
        int len = array.length;
        int count;
        for (int i = 0; i < len; i++) {
            count = 0;
            for (int i1 = 0; i1 < len; i1++) {
                if (array[i1] == array[i]) {
                    count++;
                }

                if (count > len / 2) {
                    System.out.println(array[i] + "出现了" + count + "次");
                    return array[i];
                }
            }

        }
        return -1;
    }
}
