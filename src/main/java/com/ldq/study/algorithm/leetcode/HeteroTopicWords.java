package com.ldq.study.algorithm.leetcode;

import org.junit.Test;

/**
 * 有效的字母异位词
 * 首先先判断两个字符串长度是否相同，不相同直接返回 false
 * 然后把 s 中所有的字符出现个数使用 计数器 统计起来，存入一个大小为 26 的数组中（注意题目的说明）
 * 最后再来统计 t 字符串，即遍历 t 时将对应的字母频次进行减少，如果期间  计数器  出现小于零的情况，则说明 t 中包含一个不存在于 s 中的字母，直接返回 false。
 * 最后检查计数器是否归零
 */
public class HeteroTopicWords {
    @Test
    public void isAnagram(){
        boolean isAnagram = true;
        String s = "beer";
//        String t = "raeb";
        String t = "reeb";
        //长度不等，必不同
        if (s.length() != t.length()) {
            isAnagram =  false;
        }

        int[] table = new int[26];
        //遍历每一个位子，对应字母出现的次数+1
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            //小技巧：如果在任何时候遍历后者时，计数器低于零，那肯定说明
            // t 中包含一个不存在于 s 中的字母
            if (table[t.charAt(i) - 'a'] < 0) {
                isAnagram =  false;
            }
        }
        System.out.println("isAnagram = " + isAnagram);
    }
}
