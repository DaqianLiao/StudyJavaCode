package com.ldq.study.gc.classLoader;

public class Main {
    /**
     * 父子类加载顺序
     * 先加载父类的构造方法，再加载子类的构造方法
     */
    public static void testClassLoader() {
        SonC sonC = new SonC();
        System.out.println(sonC);
    }

    public static void main(String[] args) {
        testClassLoader();
    }
}
