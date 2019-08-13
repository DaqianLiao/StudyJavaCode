package com.ldq.study.gc.classLoader.analyse;

/**
 * 父类的静态变量执行一定比子类的静态变量优先
 *
 */
public class ClinitExeOrder {
    static class Parent {
        public static int A = 1;
        static {
            A = 2;
        }
    }

    static class Sub extends Parent {
        public static int B = A;
    }

    public static void main(String[] args) {
        System.out.println(Sub.B);
    }
}
