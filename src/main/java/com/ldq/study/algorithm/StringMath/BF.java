package com.ldq.study.algorithm.StringMath;

import java.util.ArrayList;
import java.util.List;

/**
 * BF搜索算法，暴力搜索，按照两个字符串顺序遍历
 */
public class BF {
    public static void main(String[] args) {
        String main = "ababcacabcac";
        String child = "abcac";
        System.out.println(findAll(main, child));
//        System.out.println(find(main, child));
    }

    /**
     * @param text
     * @param pattern
     * @return
     */
    public static int find(String text, String pattern) {
        char[] c1 = text.toCharArray();
        char[] c2 = pattern.toCharArray();
        int i = 0;
        int j;
        //循环遍历目标串
        while (i < text.length() - 1) {
            j = 0;
            /**
             * 内部循环
             * 遍历模式串，逐一匹配，
             * 如果模式串和目标串对应位置匹配则继续
             * 否则跳出循环
             */
            while (c1[i] == c2[j] && j < pattern.length() - 1) {
                i++;
                j++;
            }

            /**
             * 判断模式串是否匹配完成，
             * 如果完成，则表示找到匹配的子串
             * 返回目标串中的起始位置
             */
            if (j == pattern.length() - 1) {
                return i - pattern.length() + 1;

            }

            //回溯目标串的索引位置
            i = i - j + 1;

        }
        //没找到则返回
        return -1;
    }


    /**
     * 返回在目标串中找到所有匹配的模式串的索引位置
     * @param main
     * @param child
     * @return
     */
    private static List<Integer> findAll(String main, String child) {
        List<Integer> positions = new ArrayList<>();
        int len = main.length();
        int cLen = child.length();
        System.out.println("main length = " + len + ", child length = " + cLen);
        int i, i1;
        for (i = 0; i < len; i++) {
            for (i1 = 0; i1 < cLen; i1++) {
                System.out.println("----------------");
                System.out.println("i1 = " + i1 + ", i = " + i);
                System.out.println("main char = " + main.charAt(i + i1));
                System.out.println("child char = " + child.charAt(i1));
                if (main.charAt(i + i1) != child.charAt(i1)) {
                    System.out.println("match");
                    break;
                }
            }
            if (i1 == cLen) {
                positions.add(i);
            }

            System.out.println("=========");
        }

        return positions;
    }
}
