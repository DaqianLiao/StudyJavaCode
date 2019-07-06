package com.ldq.study.gc.classLoader;

public class SisterC {
    static{
        System.out.println("Im sister static code");
    }


    public SisterC(String name) {
        System.out.println("Im sister class! my name is "+ name);
    }
}
