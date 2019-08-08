package com.ldq.study.gc.classLoader.entity;

/**
 * 被动使用类字段演示三：
 * 常量在编译阶段会存入调用类的常量池中，本质上没有直接引用到定义常量的类，
 * 因此不会触发定义常量的类的初始化。
 **/
public class ConstClass {

    public static final String HELLOWORLD = "hello world";

    /**
     * 静态代码块优先构造函数初始化
     */
    static {
        System.out.println("ConstClass static code init!");
    }

    public ConstClass(){
        System.out.println("ConstClass constructor init!");
    }
}
