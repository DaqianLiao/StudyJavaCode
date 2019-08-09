package com.ldq.study.gc.classLoader.analyse;

public class FieldResolution {
    interface Interface0 {
        int A = 0;
    }

    interface Interface1 extends Interface0 {
        int A = 1;
    }

    interface Interface2 {
        int A = 2;
    }

    static class Parent implements Interface1 {
        public static int A = 3;
    }

    static class Sub extends Parent implements Interface2 {
        /**
         * 当注释这行代码时，编译器会提示报错
         * A is ambiguous(模棱两可的)
         * 因为接口和父类中同时存在A字段
         */
        public static int A = 4;
    }

    public static void main(String[] args) {
        System.out.println(Sub.A);
        System.out.println(Parent.A);
    }

}
