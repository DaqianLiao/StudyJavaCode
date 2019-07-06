package com.ldq.study.gc.classLoader;

public class BrotherC {
    SisterC s1 = new SisterC("s1");
    static SisterC s1_1 = new SisterC("s1_1");
    static{
        System.out.println("Im brother static code");
    }
    public BrotherC(String name){
        System.out.println("Im Brother class! my name is "+ name);
    }
}
