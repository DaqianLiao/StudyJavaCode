package com.ldq.study.gc.classLoader.entity;
/**
 * 子类继承父类
 * 当子类初始化时，必须优先初始化父类
 */
public class SubClass extends SuperClass {

    /**
     * 子类的静态代码块，
     * 当子类初始化时，静态代码优先与构造函数初始化
     */
    static {
        System.out.println("SubClass static code init!");
    }

    /**
     * 静态代码块优先构造函数初始化
     */
    public SubClass(){
        System.out.println("SubClass constructor init!");
    }
}

