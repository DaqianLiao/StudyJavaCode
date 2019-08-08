package com.ldq.study.gc.classLoader.entity;

/**
 * 被动使用类字段演示一：
 * 通过子类引用父类的静态字段，不会导致子类初始化
 **/
public class SuperClass {

    //引用该字段，必须初始化类
    public static int VALUE = 123;
    //引用该字段，不需要初始化类
    public static final int FINAL_VALUE = 123;

    /**
     * 静态代码块优先构造函数初始化
     */
    static {
        System.out.println("SuperClass static code init!");
    }

    public SuperClass() {
        System.out.println("SuperClass constructor init!");
    }

    public static void staticMethod(){
        System.out.println("this is static method");
    }
}
