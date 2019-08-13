package com.ldq.study.gc.classLoader.analyse;

/**
 * 虚拟机会保证一个类的,<clinit>()方法在多线程中被加锁，同步
 * 也就是每次只有一个线程去初始化一个类
 */
public class DeadLoopClass {

    static class DeadLoop {
        static {
            // 如果不加上这个if语句，编译器将提示“Initializer does not complete normally”并拒绝编译
            if (true) {
                System.out.println(Thread.currentThread() + "init DeadLoop");
                while (true) {
                }
            }
        }
    }

    /**
     * 需要手动停止线程
     * 因为程序会陷入死循环
     * @param args
     */
    public static void main(String[] args) {
        Runnable script = new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread() + "start");
                //线程中完成类的初始化操作
                DeadLoop dlc = new DeadLoop();
                System.out.println(Thread.currentThread() + " run over");
            }
        };

        Thread thread1 = new Thread(script);
        Thread thread2 = new Thread(script);
        thread1.start();
        thread2.start();
    }


}
