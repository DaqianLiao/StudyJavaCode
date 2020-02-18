package com.ldq.study.algorithm.StringMath;

import java.util.Arrays;

/**
 * BM算法实现
 * https://blog.csdn.net/joylnwang/article/details/6785743
 * https://mp.weixin.qq.com/s?__biz=MzUyNjQxNjYyMg==&mid=2247486150&idx=1&sn=9e9f8c35805c66132005cb634ef18171&chksm=fa0e6547cd79ec51529d0510f18161b65e54826231fae025d2cfbbd4f8a9656460f5b2d424b3&mpshare=1&scene=23&srcid=&sharer_sharetime=1566434432409&sharer_shareid=7ac251aeea4834f0bb8f5e4682d11eba#rd
 */
public class BM {

    /**
     * 算法匹配
     */
    public static int isMatch(String pattern, String target) {
        int tLen = target.length();
        int pLen = pattern.length();

        if (pLen > tLen) {
            return -1;
        }

        int[] bad_table = build_bad_table(pattern);// 1,3,5,6,2,
        int[] good_table = build_good_table(pattern);// 1,8,5,10,11,12,13

        for (int i = pLen - 1, j; i < tLen;) {
            System.out.println("跳跃位置：" + i);
            for (j = pLen - 1; target.charAt(i) == pattern.charAt(j); i--, j--) {
                if (j == 0) {
                    System.out.println("匹配成功，位置：" + i);
//					i++;   // 多次匹配
//					break;
                    return i;
                }
            }
            i += Math.max(good_table[pLen - j - 1], bad_table[target.charAt(i)]);
        }
        return -1;
    }

    /**
     * 字符信息表
     */
    public static int[] build_bad_table(String pattern) {
        final int table_size = 256;
        int[] bad_table = new int[table_size];
        int pLen = pattern.length();

        for (int i = 0; i < bad_table.length; i++) {
            bad_table[i] = pLen;  //默认初始化全部为匹配字符串长度
        }
        for (int i = 0; i < pLen - 1; i++) {
            int k = pattern.charAt(i);
            bad_table[k] = pLen - 1 - i;
        }
//		for (int i : bad_table) {
//			if (i != 7) {
//				System.out.print(i + ",");
//			}
//		}
        System.out.println("bad_table = " + Arrays.toString(bad_table));
        return bad_table;
    }

    /**
     * 匹配偏移表。
     *
     * @param pattern
     *            模式串
     * @return
     */
    public static int[] build_good_table(String pattern) {
        int pLen = pattern.length();
        int[] good_table = new int[pLen];
        int lastPrefixPosition = pLen;

        for (int i = pLen - 1; i >= 0; --i) {
            if (isPrefix(pattern, i + 1)) {
                lastPrefixPosition = i + 1;
            }
            good_table[pLen - 1 - i] = lastPrefixPosition - i + pLen - 1;
        }

        for (int i = 0; i < pLen - 1; ++i) {
            int slen = suffixLength(pattern, i);
            good_table[slen] = pLen - 1 - i + slen;
        }
        return good_table;
    }

    /**
     * 前缀匹配
     */
    private static boolean isPrefix(String pattern, int p) {
        int patternLength = pattern.length();
        for (int i = p, j = 0; i < patternLength; ++i, ++j) {
            if (pattern.charAt(i) != pattern.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 后缀匹配
     */
    private static int suffixLength(String pattern, int p) {
        int pLen = pattern.length();
        int len = 0;
        for (int i = p, j = pLen - 1; i >= 0 && pattern.charAt(i) == pattern.charAt(j); i--, j--) {
            len += 1;
        }
        return len;
    }

    public static void main(String[] args) {
        isMatch("abcac", "abcabacbabcacabcac");
    }
}
