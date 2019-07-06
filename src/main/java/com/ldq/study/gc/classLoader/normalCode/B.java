package com.ldq.study.gc.classLoader.normalCode;

public class B {
    static {
        System.out.println("static B");
    }

    public B() {
        System.out.println("Class B");
    }
}
