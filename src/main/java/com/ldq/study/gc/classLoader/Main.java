package com.ldq.study.gc.classLoader;

public class Main {
    /**
     * 第一点，所有的类都会优先加载基类
     * 第二点，静态成员的初始化优先
     * 第三点，成员初始化后，才会执行构造方法
     * 第四点，静态成员的初始化与静态块的执行，发生在类加载的时候。
     * 第四点，类对象的创建以及静态块的访问，都会触发类的加载。
     */
    public static void testClassLoader() {
        SonC sonC = new SonC();
    }

    public static void main(String[] args) {
        testClassLoader();
    }
}
