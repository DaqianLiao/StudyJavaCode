package com.ldq.study.string;

public class StringBuilderJavaP {

    /**
     * 值拼接的时候，虚拟机直接从常量池中获取值，拼接，
     * 如果值没有变化，就是同一个地址
     */
    public static void noBuilder() {
        String s1 = "111";
        String s2 = "111" + "";
        System.out.println(s1 == s2);
    }


    /**
     * 变量和字符串拼接的时候，虚拟机需要先到内存中找到变量对应的值，
     * 此时，只能通过Stringbuilder方式拼接，然后toString方法返回的结果，
     * 相当于在内存中开辟了一个新的空间存储，所以两者地址不一样
     *
     */
    public static void builder() {
        String s1 = "111";
        String s2 = s1 + "";
        System.out.println(s1 == s2);
    }

    public static void main(String[] args) {
        builder();
        noBuilder();
    }
}
