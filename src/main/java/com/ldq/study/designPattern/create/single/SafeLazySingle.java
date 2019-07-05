package com.ldq.study.designPattern.create.single;

/**
 * 按需分配，只有需要的时候才会创建对象，创建对象需要时间
 * 使用synchronized加锁，使的变成线程安全的
 */
public class SafeLazySingle {

    private static SafeLazySingle instance ;

    //私有化构造函数，这样外部不能直接实例化该类
    private SafeLazySingle() {
    }

    /**
    * 对整个方法枷锁，此时绝对使线程安全的
     * 但是如果方法中的逻辑较多，耗时较长
    */
    public static synchronized SafeLazySingle getInstance() {
        //在使用的时候，才会创建
        if (instance == null) {
            instance = new SafeLazySingle();
        }
        return instance;
    }
}
