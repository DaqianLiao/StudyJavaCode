package com.ldq.study.algorithm.StringMath;


import java.util.ArrayList;
import java.util.List;

/**
 * Sunday 字符串匹配算法，
 * 由于可以大范围跳过不匹配字符，效率高
 *
 */
public class Sunday {

    public static void main(String[] args) {
        String text = "abababzabababa";
        String pattern = "ababa";
        System.out.println(search(text, pattern));
        System.out.println(sunday(text, pattern));
    }

    private static List<Integer> sunday(String text, String pattern) {
        List<Integer> positions = new ArrayList<>();
        char[] main = text.toCharArray();
        char[] p = pattern.toCharArray();

        int i = 0, j = 0;

        while (i <= (main.length - p.length + j)) {

            if (main[i] != p[j]) {
                if (i == main.length - p.length + j) {
                    break;
                }
                int pos = getLastIndex(pattern, main[i + p.length - j]);
                if (pos == -1) {
                    i = i + p.length - j + 1;

                } else {
                    i = i + p.length - j - pos;
                }
                j = 0;
            } else {
                if (j == p.length - 1) {
                    positions.add(i - j);
                    i = i - j + 1;
                    j = 0;
                } else {
                    i++;
                    j++;
                }
            }
        }

        return positions;
    }

    /**
     * 方便调试
     *
     * @param text
     * @param pattern
     * @return
     */
    private static List<Integer> search(String text, String pattern) {
        List<Integer> positions = new ArrayList<>();

        int index = 0;
        int j = 0;
        while (index < text.length() - pattern.length() + 1) {
            System.out.println("main char = " + text.charAt(index) + ", pattern char = " + pattern.charAt(j));
            System.out.println("main index = " + index + ", pattern index = " + (j));
            //遍历查找相等的字符
            while (j < pattern.length() && text.charAt(index) == pattern.charAt(j)) {
                System.out.println("main char = " + text.charAt(index) + ", pattern char = " + pattern.charAt(j));
                System.out.println("match");
                index++;
                j++;
            }
            System.out.println("index= " + index + ", j = " + j);

            if (j == pattern.length()) {
                //index - j 就是起始index
                positions.add(index - j);
                //当匹配到字符后，应该从起始index的下一为开始重新匹配
                index = index - j + 1;
                j = 0;
                System.out.println("===============");
            } else {
                System.out.println("not match");
                System.out.println("index= " + index + ", j = " + j);
                /**不匹配跳出循环后，将目标串所以增加移动距离后，
                 * 查找新索引位置在模式串中的最后一次出现的索引位置
                 * 移动距离：模式串索引距离模式串末尾的距离+1
                 * 即 index + pattern.length - j
                 * 由于跳出循环时，index已经++了，所以这个地方不需要重复+1
                 */
                char next = text.charAt(index + pattern.length() - j);
                int pos = getLastIndex(pattern, next);
                System.out.println("pos = " + pos);
                if (pos == -1) {
                    /**
                     * 如果没有找到，说明整个子串中都没有模式串的字符，
                     * 这一整段都可以跳过，直接将索引移到下一位即可
                     */
                    index = index + pattern.length() - j + 1;
                } else {
                    /**
                     * 如果找到了，说明当前字符在模式串中出现过
                     * 则移动模式串和目标串对齐，再一定两个索引，
                     * 从头开始匹配模式串和目标串
                     */
                    index = index + pattern.length() - j - pos;
                }
                //由于从新匹配，将模式串索引置0
                j = 0;
                System.out.println("index= " + index + ", j = " + j);
            }

        }

        return positions;
    }


    /**
     * 在pattern中查找字符c, 找到返回index，没找到返回-1
     *
     * @param pattern
     * @param c
     * @return
     */
    private static int getLastIndex(String pattern, char c) {
        return pattern.lastIndexOf(c);
    }

}
