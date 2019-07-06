package com.ldq.study.gc.classLoader.normalCode;

public class A {
    B b ;
    static {
        System.out.println("static A");
    }

    public A() {
        System.out.println("class A");
    }
}
