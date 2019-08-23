package com.ldq.study.string;

public class EqualsDemo {

    public static void testEqual(){
//        ==判断是否相等
        String str1 = "hello";
        String str2 = "hello";
//        true 因为两个地址相同，都存在与常量池中
        System.out.println(str1 == str2);
        String str3 = new String("hello");
//        false 因为str3是在堆中新创建的对象，和str1地址不一样
        System.out.println(str1 == str3);

//       查看源码可知两者先比较地址是否相同，后比较值是否相同
        System.out.println(str1.equals(str3));//true
    }

    public static void main(String[] args) {
        testEqual();
    }
}
