package com.ldq.study.designPattern.create.single;

/**
 * 按需分配，只有需要的时候才会创建对象，创建对象需要时间
 * 线程安全的
 */
public class StaticInner {

    //私有化构造函数，这样外部不能直接实例化该类
    private StaticInner() {
        System.out.println("主类被加载");
    }

    //私有化的静态内部类，外部不可见
    private static class Singleton{
        private static final StaticInner StaticInner = new StaticInner();
    }

    //申明静态方法，返回实例
    public static StaticInner getInstance() {
        return Singleton.StaticInner;
    }
}
