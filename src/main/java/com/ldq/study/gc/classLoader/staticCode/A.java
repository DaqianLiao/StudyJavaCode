package com.ldq.study.gc.classLoader.staticCode;

public class A {
    static B b = new B();
    static {
        System.out.println("static A");
    }

    public A() {
        System.out.println("class A");
    }
}
