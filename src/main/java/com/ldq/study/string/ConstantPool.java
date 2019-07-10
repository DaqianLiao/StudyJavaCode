package com.ldq.study.string;

/**
 * 对比常量池 堆内存 final修饰变量以及intern方法的情况
 */
public class ConstantPool {
    public static void normal() {
        String s1 = "hello";
        String s2 = new String("hello");
        //不想等，s1在常量池中，s2在堆内存中
        System.out.println(s1 == s2);
    }

    public static void concat(){
        String s1 = "hello";
        String s3 = " world";
        String s4 = "hello" + " world";
        String s5 = s1 + s3;
        //不想等，s4在常量池中，s5是有stringbuilder连接生成在堆内存中
        System.out.println(s4 == s5);

        String s6 = "hello world";
        //相等，s4 s6都存在常量池中
        System.out.println(s4 == s6);
    }

    public static void testFinal(){
        String s1 = "hello";
        String s3 = " world";
        String s4 = "hello" + " world";
        //final 修饰的变量通过引用拼接，依然是通过stringbuilder连接，在堆内存中生成
        final String s7 = s1 + s3;
        //不相等
        System.out.println(s4 == s7);


        //final修饰常量，对应的会在编译器将变量用常量替换，相当于字符串拼接
        final String s8 = "hello";
        final String s9 = " world";
        String s10 = s8 + s9;
        //相等
        System.out.println(s4 == s10);
    }

    /**
     * intern方法是string类中的native方法
     * 获取当前字符串在常量池中的数据
     * 如果常量池中存在，则直接返回常量池中数据
     * 如果常量池中不存砸，则把数据添加到常量池中后，返回常量池中数据
     */
    public static void intern(){
        String s1 = "abc";
        String s2 = s1.intern();
        //相等，因为都是常量池中数据
        System.out.println(s1==s2);
        String s3 = new String("world");
        String s3_1 = s3.intern();
        String s4 = "world";
        //相等，常量池中不存在，将world放到常量池中去
        System.out.println(s3_1 == s4);

        String s5 = "nice";
        String s6 = new String("nice");
        //相等，常量池中存在，直接返回常量池中数据
        System.out.println(s5 == s6.intern());
        //直接比较常量池中情况
        System.out.println(s5.intern() == s6.intern());
        //前者在堆内存中，后者在常量池中
        System.out.println(s6 == s6.intern());
    }


    public static void main(String[] args) {
        normal();
        concat();
        testFinal();
        intern();
    }
}
