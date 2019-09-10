package com.ldq.study.algorithm.sort;

import java.util.Arrays;

/**
 * 合并三个数组，实现归并算法
 */
public class ThreeArrayCompareSort {

    public static void main(String[] args) {

        int[] a = new int[]{0, 1, 2, 3, 4, 7};
        int[] b = new int[]{1, 4, 7, 9};
        int[] c = new int[]{1, 2, 3, 4, 5, 9, 11, 19};

        threeArrayCompare(a, b, c);
    }

    private static void threeArrayCompare(int[] a, int[] b, int[] c) {
        int i = 0, j = 0, k = 0, l = 0;
        int aLen = a.length;
        int bLen = b.length;
        int cLen = c.length;
        int[] temp = new int[0];
        int[] result = new int[aLen + bLen + cLen];

        while (i < aLen && j < bLen && k < cLen) {
            if (a[i] <= b[j]) {
                if (a[i] <= c[k]) {
                    result[l++] = a[i++];
                } else {
                    result[l++] = c[k++];
                }
            } else {
                if (b[j] <= c[k]) {
                    result[l++] = b[j++];
                } else {
                    result[l++] = c[k++];
                }
            }
        }
        System.out.println(Arrays.toString(result));

        if (i == aLen) {
            System.out.println("compare b,c");
            temp = twoArrayCompare(b, j, c, k);
        }
        if (j == bLen) {
            System.out.println("compare a,c");
            temp = twoArrayCompare(a, i, c, k);
        }
        if (k == cLen) {
            System.out.println("compare a,b");
            temp = twoArrayCompare(a, i, b, j);
        }

        for (int i1 = 0; i1 < temp.length; i1++) {
            result[l++] = temp[i1];
        }

        System.out.println(Arrays.toString(result));
    }

    private static int[] twoArrayCompare(int[] b, int i, int[] c, int j) {
        System.out.println("indexB = " + i + ", indexC = " + j);
        int k = 0;
        int bLen = b.length;
        int cLen = c.length;
        System.out.println("bLen = " + bLen + ", cLen = " + cLen);
        int[] temp = new int[bLen - i + cLen - j];
        while (i < bLen && j < cLen) {
            if (b[i] <= c[j]) {
                temp[k++] = b[i++];
            } else {
                temp[k++] = c[j++];
            }
        }

        System.out.println("temp = " + Arrays.toString(temp));
        System.out.println("indexB = " + i + ", indexC = " + j);
        while (i < bLen) {
            temp[k++] = b[i++];
        }

        while (j < cLen) {
            temp[k++] = c[j++];
        }
        System.out.println("temp = " + Arrays.toString(temp));
        return temp;
    }
}
