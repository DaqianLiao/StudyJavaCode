package com.ldq.study.gc.classLoader;

public class SonC extends ParentC {

    BrotherC b1 = new BrotherC("b1");
    static BrotherC b1_1 = new BrotherC("b1_1");
    static {
        System.out.println("Im son static code");
    }

    BrotherC b2 = new BrotherC("b2");
    static BrotherC b2_1 = new BrotherC("b2_1");
    public SonC(){
        System.out.println("Im son class");
        BrotherC b3 = new BrotherC("b3");
    }
}
