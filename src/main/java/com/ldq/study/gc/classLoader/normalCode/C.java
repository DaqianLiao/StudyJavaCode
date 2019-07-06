package com.ldq.study.gc.classLoader.normalCode;

public class C {
    B b = new B();
    static {
        System.out.println("static C");
    }

    public C() {
        System.out.println("class C");
    }
}
