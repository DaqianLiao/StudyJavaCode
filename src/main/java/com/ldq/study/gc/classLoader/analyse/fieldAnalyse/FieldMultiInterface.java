package com.ldq.study.gc.classLoader.analyse.fieldAnalyse;

/**
 *
 */
public class FieldMultiInterface {
    interface Interface0 {
        int A = 0;
    }

    interface Interface1 {
        int A = 1;
    }

    interface Interface2 extends Interface1 {
        int A = 2;
    }

    interface Interface3 extends Interface1 {
    }

    static class Field1 implements Interface0, Interface1 {
    }

    static class Field2 implements Interface0{}
    static class Field3 implements Interface1{}
    static class Field4 implements Interface2{}
    static class Field5 implements Interface3{}

    static class Parent implements Interface0{
        public static int A = 10;
    }

    static class Pa {
        public static int A = 11;
    }
    static class Field6 extends Parent implements Interface1 {
    }

    static class Field7 extends Pa implements Interface1 {
    }
    public static void main(String[] args) {
        /**
         * 类如果同时实现了多个接口，如果多个接口中都包含了字段A
         * 编译时，就会提示字段A不确定赋值的情况
         */
//        System.out.println("Field1.A = " + Field1.A);
        //本类中没有，接口中有字段，返回接口中的值
        System.out.println("Field2.A = " + Field2.A);
        //本类中没有，接口中有字段，返回接口中的值
        System.out.println("Field3.A = " + Field3.A);
        //本类中没有，接口2和接口2继承的接口1中有字段，返回接口2中的值
        System.out.println("Field4.A = " + Field4.A);

        //本类中没有，接口3中没有，和接口3继承的接口1中有字段，返回接口1中的值
        System.out.println("Field5.A = " + Field5.A);
        /**
         * 类继承的父类中和接口中同时存在字段A
         * 编译时，就会提示字段A不确定赋值的情况
         */
//        System.out.println("Field6.A = " + Field6.A);
//        System.out.println("Field7.A = " + Field7.A);
        System.out.println("Parent.A = " + Parent.A);

    }
}
