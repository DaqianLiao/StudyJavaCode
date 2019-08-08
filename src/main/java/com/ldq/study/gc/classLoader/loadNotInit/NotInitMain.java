package com.ldq.study.gc.classLoader.loadNotInit;

import com.ldq.study.gc.classLoader.entity.ConstClass;
import com.ldq.study.gc.classLoader.entity.SubClass;
import com.ldq.study.gc.classLoader.entity.SuperClass;

import java.util.Arrays;

public class NotInitMain {

    public static void main(String[] args) {
//        subClassUseSuperClassStaticFinalField();
//        subClassUseSuperClassStaticField();
//        defineSuperClassArray();
//        defineSubClassArray();
//        constClassFinalField();
        staticMethod();
    }

    /**
     * 被动使用类字段演示1
     * <p>
     * 子类引用父类的静态字段，
     * 子类不会初始化，但是父类会初始化
     */
    public static void subClassUseSuperClassStaticField() {
        System.out.println(SubClass.VALUE);
    }

    /**
     * 被动使用类字段演示1-ex1
     * <p>
     * 子类引用父类的静态字段，
     * 子类不会初始化，父类也不会初始化
     * 因为被final修饰的字段在编译器已经添加到类的常量池中，因此不用初始化
     */
    public static void subClassUseSuperClassStaticFinalField() {
        System.out.println(SubClass.FINAL_VALUE);
    }


    /**
     * 被动使用类字段演示2
     * 通过数组定义来引用父类，不会触发父类的初始化
     **/
    public static void defineSuperClassArray() {
        SuperClass[] sca = new SuperClass[2];
        System.out.println("Arrays.toString(sca) = " + Arrays.toString(sca));
    }


    /**
     * 被动使用类字段演示2-ex
     * 通过数组定义来引用子类，不会触发此子类和父类的初始化
     **/
    public static void defineSubClassArray() {
        SubClass[] sca = new SubClass[2];
        System.out.println("Arrays.toString(sca) = " + Arrays.toString(sca));
    }

    /**
     * 被动使用类字段演示3
     *
     * 常量在编译阶段会存入调用类的常量池中，本质上没有直接引用到定义常量的类，
     * 因此不会触发定义常量的类的初始化。
     **/
    public static void constClassFinalField() {
        System.out.println(ConstClass.HELLOWORLD);
    }

    /**
     * 调用类的静态方法，会加载类的静态代码块
     * 但是不会执行类的构造函数初始化
     */
    public static void staticMethod(){
        SuperClass.staticMethod();
    }
}
