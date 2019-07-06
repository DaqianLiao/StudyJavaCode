package com.ldq.study.gc.classLoader.staticCode;

public class Main {

    public static void testStaticOrder(){
        A a = new A();
    }

    public static void testOther(){
        C c = new C();
    }

    /**
     * 静态代码块优先执行，然后执行构造函数
     * 重点：静态代码块按照顺序执行
     * @param args
     */
    public static void main(String[] args) {
//        testStaticOrder();
        testOther();
    }
}
