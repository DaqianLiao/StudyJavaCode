package com.ldq.study.algorithm.StringMath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KMP {

    public static void main(String[] args) {
        String text = "abababzabababa";
        String pattern = "ababa";
        calculateMaxMatchLengths(pattern);
        search(text, pattern);
    }


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
            while (count > 0 && pattern.charAt(count) != text.charAt(i)) {
                count = maxMatch[count - 1];
                System.out.println("move to count = " + count + ", now string index = " + i);
            }
            if (pattern.charAt(count) == text.charAt(i)) {
                count++;
            }
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
