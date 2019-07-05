package com.ldq.study.designPattern.create.single;

/**
 * 线程安全
 * 饿汉模式，无论是否使用，都会创建对象，占用内存空间
 *
 */
public class HungrySingle {
    //随着类初始化的时候，创建实例，由类加载器保证单例
    private static HungrySingle instance = new HungrySingle();

    //私有化构造函数，这样外部不能直接实例化该类
    private HungrySingle() {
    }

    //申明静态方法，返回实例
    public static  HungrySingle getInstance() {
        return instance;
    }
}
