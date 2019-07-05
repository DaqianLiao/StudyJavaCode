package com.ldq.study.designPattern.create.single;

/**
 * 按需分配，只有需要的时候才会创建对象，创建对象需要时间
 * 使用synchronized加锁，使的变成线程安全的
 */
public class LockObjectLazySingle {

    private static LockObjectLazySingle instance;

    //私有化构造函数，这样外部不能直接实例化该类
    private LockObjectLazySingle() {
    }

    /**
     * 对具体的创建对象步骤枷锁，减少锁力度大小
     */
    public static LockObjectLazySingle getInstance() {
        //在使用的时候，才会创建
        if (instance == null) {
            synchronized (LockObjectLazySingle.class) {
                instance = new LockObjectLazySingle();
            }
        }
        return instance;
    }
}
