package com.ldq.study.gc.classLoader.loadMustInit;

import com.ldq.study.gc.classLoader.entity.SubClass;
import com.ldq.study.gc.classLoader.entity.SuperClass;

public class MustInitMain {

    public static void main(String[] args) {
//        newSuperClassLoad();
//        newSubClassLoad();
//        getStaticField();
        setStaticField();
    }

    /**
     * new Class case
     * 这种方式创建对象一定会触发初始化
     * 初始化一个没有父类的（或者本身就是父类，被子类继承的类）类，直接初始化即可
     */
    public static void newSuperClassLoad() {
        new SuperClass();
    }

    /**
     * new Class case
     * 这种方式创建对象一定会触发初始化
     * 初始化一个子类，必须保证父类也被初始化
     * 顺序：先初始化父类，在初始化子类
     */
    public static void newSubClassLoad() {
        new SubClass();
    }

    /**
     * getstatic case 调用静态类变量
     * 会执行类的静态<clinit>()初始化方法
     * 但是不会执行构造函数<init>()初始化
     */
    public static void getStaticField() {
        System.out.println("SuperClass.VALUE = " + SuperClass.VALUE);
    }

    /**
     * setstatic case 调用静态类变量
     * 会执行类的静态<clinit>()初始化方法
     * 但是不会执行构造函数<init>()初始化
     * 这个执行流程很有意思：
     * 先执行类中静态代码块，会打印初始化时value的值为123
     * 类加载完成后，会执行set value = 234；
     * 最后打印加载后的value值
     */
    public static void setStaticField() {
        SuperClass.VALUE = 234;
        System.out.println("SuperClass.VALUE = " + SuperClass.VALUE);
    }

    /**
     * invokestatic case
     * 调用类的静态方法，
     * 会执行类的静态<clinit>()初始化方法
     * 但是不会执行构造函数<init>()初始化
     */
    public static void staticMethod() {
        SuperClass.staticMethod();
    }

}
