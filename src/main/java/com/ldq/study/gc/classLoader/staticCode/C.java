package com.ldq.study.gc.classLoader.staticCode;

public class C {

    static {
        System.out.println("static C");
    }
    static B b = new B();

    public C() {
        System.out.println("class C");
    }
}
