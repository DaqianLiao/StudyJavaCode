package com.ldq.study.algorithm.StringMath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.zhihu.com/question/21923021/answer/37475572
 */
public class KMP {

    public static void main(String[] args) {
        String text = "sabababzabababa";
        String pattern = "ababa";
        calculateMaxMatchLengths(pattern);
        search(text, pattern);
    }

    /**
     * 输入模式串，得到模式串的自匹配数组
     *
     * @param pattern
     * @return
     */
    private static int[] calculateMaxMatchLengths(String pattern) {
        int patternLen = pattern.length();
        int[] maxMatch = new int[patternLen];
        int maxLength = 0;
        for (int i = 1; i < patternLen; i++) {
            while (maxLength > 0 && pattern.charAt(maxLength) != pattern.charAt(i)) {
                maxLength = maxMatch[maxLength - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(maxLength)) {
                maxLength++;
            }
            maxMatch[i] = maxLength;
        }
        System.out.println(Arrays.toString(maxMatch));
        return maxMatch;
    }

    private static List<Integer> search(String text, String pattern) {
        List<Integer> positions = new ArrayList<>();
        int[] maxMatch = calculateMaxMatchLengths(pattern);
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            System.out.println("pattern char = " + pattern.charAt(count) +
                    ", string index char = " + text.charAt(i));
            System.out.println("count = " + count + ", index = " + i);
            /**
             * count>0:主要约束在当首位字符匹配不到的情况
             * 其他的就是当字符不匹配时，会退到最大后缀判断是否匹配
             */
            while (count > 0 && pattern.charAt(count) != text.charAt(i)) {
                count = maxMatch[count - 1];
                System.out.println("move to count = " + count + ", now string index = " + i);
            }
            //如果字符相同，则将模式串的索引count+1
            if (pattern.charAt(count) == text.charAt(i)) {
                count++;
            }
            //如果匹配长度和模式串长度一致，说明此时已经找到了结果
            //根据最长前缀移动模式串
            if (count == pattern.length()) {
                positions.add(i - pattern.length() + 1);
                System.out.println("count = " + count + ", string index = " + i);
                count = maxMatch[count - 1];
//                count = 0;
                System.out.println("new count = " + count);
            }

        }
        System.out.println(positions.toString());
        return positions;

    }
}
