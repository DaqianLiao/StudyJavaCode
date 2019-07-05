package com.ldq.study.designPattern.create.single;

/**
 * 按需分配，只有需要的时候才会创建对象，创建对象需要时间
 * 使用synchronized加锁，使的变成线程安全的
 */
public class CheckLockObjectLazySingle {

    private static CheckLockObjectLazySingle instance;

    //私有化构造函数，这样外部不能直接实例化该类
    private CheckLockObjectLazySingle() {
    }

    /**
     * 对具体的创建对象步骤枷锁，减少锁力度大小
     */
    public static CheckLockObjectLazySingle getInstance() {
        if (instance == null) {
            synchronized (CheckLockObjectLazySingle.class) {
                //在同步方法中再一次判断是否为null
                if (instance == null) {
                    instance = new CheckLockObjectLazySingle();
                }
            }
        }
        return instance;
    }
}
