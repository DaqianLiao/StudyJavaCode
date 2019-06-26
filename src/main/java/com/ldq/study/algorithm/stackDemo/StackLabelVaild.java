package com.ldq.study.algorithm.stackDemo;

import java.util.Stack;

public class StackLabelVaild {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效
     * 遍历整个字符串，没找到匹配的括号时，入栈，找到匹配的括号时，出栈
     * 直到遍历完所有的字符串，栈中没有数据，就是合法的字符串
     * @param str
     * @return
     */
    public static  boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();

        for (char aChar : chars) {
            if (stack.size() == 0) {
                stack.push(aChar);
            } else if (isSym(stack.peek(), aChar)) {
                stack.pop();
            } else {
                stack.push(aChar);
            }
        }
        return stack.size() == 0;
    }

    /**
     * 判断c1 c2是否匹配，需要按照顺序匹配
     * @param c1
     * @param c2
     * @return
     */
    private static boolean isSym(char c1, char c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}');
    }

    public static void main(String[] args) {
        String label = "(){}[]";
        System.out.println("label = \"" + label + "\" is valid:" + isValid(label));
    }
}
