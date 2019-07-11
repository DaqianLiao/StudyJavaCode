package com.ldq.study.designPattern.create.single;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void testHungry() {
        HungrySingle h1 = HungrySingle.getInstance();
        HungrySingle h2 = HungrySingle.getInstance();
        System.out.println(h1 == h2);

    }

    public static void testLazy() {
        LazySingle lazySingle1 = LazySingle.getInstance();
        LazySingle lazySingle2 = LazySingle.getInstance();
        System.out.println(lazySingle1 == lazySingle2);
    }

    public static void testUnsafeLazy() {

        //模拟线程不安全的情况
        for (int i = 0; i < 10; i++) {
            new Thread(() ->
            {
                try {
                    String name = Thread.currentThread().getName();
                    LazySingle h = LazySingle.getInstance();
                    System.out.println(name + " create single = " + h.hashCode());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }, "thread_" + i)
                    .start();
        }
    }

    public static void testSafeLazy() {
        //模拟线程安全的情况
        for (int i = 0; i < 10; i++) {
            new Thread(() ->
            {
                String name = Thread.currentThread().getName();
                SafeLazySingle h = SafeLazySingle.getInstance();
                System.out.println(name + " create single = " + h);
            }, "thread_" + i)
                    .start();
        }
    }

    /**
     * 如果没有出现，多运行几次
     * 可能会出现创建的对象不是单例的情况
     */
    public static void testLockObject() {
        for (int i = 0; i < 100; i++) {
            new Thread(() ->
            {
                String name = Thread.currentThread().getName();
                LockObjectLazySingle h = LockObjectLazySingle.getInstance();
                System.out.println(name + " create single = " + h);
            }, "thread_" + i)
                    .start();
        }
    }


    /**
     * 此时的线程使安全的，但是可能会出现创建的对象不是单例的情况
     */
    public static void testCheckLockObject() {
        for (int i = 0; i < 1000; i++) {
            new Thread(() ->
            {
                String name = Thread.currentThread().getName();
                CheckLockObjectLazySingle h = CheckLockObjectLazySingle.getInstance();
                System.out.println(name + " create single = " + h);
            }, "thread_" + i)
                    .start();
        }
    }

    /**
     * 此时的线程使安全的
     */
    public static void testDoubleCheck() {
        for (int i = 0; i < 10; i++) {
            new Thread(() ->
            {
                String name = Thread.currentThread().getName();
                CheckLockObjectLazySingle h = CheckLockObjectLazySingle.getInstance();
                System.out.println(name + " create single = " + h);
            }, "thread_" + i)
                    .start();
        }
    }

    /**
     * 静态内部类保证单例，线程安全
     */
    public static void testStaticInner() {
        StaticInner s1 = StaticInner.getInstance();
        StaticInner s2 = StaticInner.getInstance();
        System.out.println(s1 == s2);
    }

    /**
     * 枚举机制保证单例
     */
    public static void testEnum() {
        EnumSingle e1 = EnumSingle.ENUM_SINGLE;
        EnumSingle e2 = EnumSingle.ENUM_SINGLE;
        System.out.println(e1 == e2);
    }

    /**
     * 通过程序串行的方式执行
     */
    public static void testCasSingleThread(){
        CasSingle single1 = CasSingle.getInstance();
        CasSingle single2 = CasSingle.getInstance();
        CasSingle single3 = CasSingle.getInstance();
        System.out.println(single1 == single2);
        System.out.println(single1 == single3);
        System.out.println("final single hashcode = " + single1.hashCode());
    }

    /**
     * 模拟高并发下，cas 这种方式下的缺点
     * 多运行几次，就可以看到会生成多个临时变量
     */
    public static void testMultiThreadCasSingle(){
        int num = 1000;
        ExecutorService pool = Executors.newFixedThreadPool(num);
        for (int i = 0; i < num; i++) {
            pool.execute(()->{
                CasSingle single = CasSingle.getInstance();
                System.out.println("final single hashcode = " + single.hashCode());
            });
        }
        pool.shutdown();
    }
    public static void main(String[] args) {
//        testLazy();
//        testHungry();
//        testUnsafeLazy();
//        testSafeLazy();
//        testLockObject();
//        testCheckLockObject();
//        testDoubleCheck();
//        testStaticInner();
//        testCasSingleThread();

     testMultiThreadCasSingle();
    }

}
