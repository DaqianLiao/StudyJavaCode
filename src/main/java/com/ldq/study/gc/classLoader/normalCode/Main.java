package com.ldq.study.gc.classLoader.normalCode;

public class Main {
    /**
     * 普通的类成员变量，未使用的时候，不会加载该成员变量的任何方法
     */
    public static void testNullNormalCode(){
        A a = new A();
    }

    /**
     * 普通的类成员变量，如果初始化了，则会在加载该类
     * 加载顺序：
     * 1/先加载类C的静态代码块
     * 2/加载类成员变量B的静态代码块，加载构造函数
     * 3/加载类C的构造方法
     */
    public static void testInitNormalCode(){
        C c = new C();
    }



    public static void main(String[] args) {
        testInitNormalCode();
//        testNullNormalCode();
    }
}
