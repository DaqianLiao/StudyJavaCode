package com.ldq.study.gc.classLoader;

public class ParentC {

    static {
        System.out.println("Im father static code");
    }
    public ParentC(){
        System.out.println("Im father class!");
    }
}
