package com.ldq.study.gc.classLoader;

/**
 * 编译就会报illegal forward reference
 */
public class UnAllowUseStaticField {
    static {
        i = 0;  //  给变量赋值可以正常编译通过
        //任何访问都会报错
//        i= i+1;
//        System.out.print(i);  // 这句编译器会提示“非法向前引用”
    }
    static int i = 1;

    public static void main(String[] args) {
        System.out.println("i = " + i);
    }
}
