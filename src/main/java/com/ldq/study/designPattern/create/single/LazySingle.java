package com.ldq.study.designPattern.create.single;

/**
 * 按需分配，只有需要的时候才会创建对象，创建对象需要时间
 * 单线程下是OK的
 * 不是线程安全的
 */
public class LazySingle {

    private static LazySingle instance ;

    //私有化构造函数，这样外部不能直接实例化该类
    private LazySingle() {
    }

    //申明静态方法，返回实例
    public static LazySingle getInstance() {
        //在使用的时候，才会创建
        if (instance == null) {
            instance = new LazySingle();
        }
        return instance;
    }
}
