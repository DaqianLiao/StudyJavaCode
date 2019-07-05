package com.ldq.study.designPattern.create.single;

/**
 * 按需分配，只有需要的时候才会创建对象，创建对象需要时间
 * 使用synchronized加锁，volatile禁止重排序，使的变成线程安全的
 */
public class DoubleCheckSingle {

    //volatile 保证了可见行，禁止指令重排序
    private static volatile DoubleCheckSingle instance;

    //私有化构造函数，这样外部不能直接实例化该类
    private DoubleCheckSingle() {
    }

    /**
     * 对具体的创建对象步骤枷锁，减少锁力度大小
     */
    public static DoubleCheckSingle getInstance() {
        //在使用的时候，才会创建
        if (instance == null) {
            synchronized (DoubleCheckSingle.class) {
                instance = new DoubleCheckSingle();
            }
        }
        return instance;
    }
}
