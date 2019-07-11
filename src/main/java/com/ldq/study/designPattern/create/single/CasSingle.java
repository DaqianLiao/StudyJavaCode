package com.ldq.study.designPattern.create.single;


import java.util.concurrent.atomic.AtomicReference;

/**
 * 不需要通过锁来实现线程安全
 * 由于没有了线程切换和阻塞的开销，能够提高更大的并发性
 *
 */
public class CasSingle {
    //AtomicReference 所持有的引用变量使用volatile 修饰，保证了可见性
    private static final AtomicReference<CasSingle> instance = new AtomicReference<>();

    //私有化构造函数，不允许外部创建
    private CasSingle(){}

    public static CasSingle getInstance() {
        //死循环，直到返回实例对象
        for (; ; ) {
            CasSingle casSingle = instance.get();
            if (casSingle != null) {
                return casSingle;
            }

            /**
             * 重要缺点
             * 当有多个线程同时执行到这一步，会在堆内存中创建很多个对象
             *
             */
            casSingle = new CasSingle();

            System.out.println("temp single hashcode = " + casSingle.hashCode());
            /**
             * 通过忙于等待的算法，进行比较，比较消耗cpu
             * 如果不同，则把casSingle的值复制给instance，通过可见性，刷新所有的值
             */
            if (instance.compareAndSet(null, casSingle)) {
                return casSingle;
            }
        }
    }

    public static void main(String[] args) {
        CasSingle single1 = CasSingle.getInstance();
        CasSingle single2 = CasSingle.getInstance();
        CasSingle single3 = CasSingle.getInstance();
        System.out.println(single1 == single2);
        System.out.println(single1 == single3);

    }
}
