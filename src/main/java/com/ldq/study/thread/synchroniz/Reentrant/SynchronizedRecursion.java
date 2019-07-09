package com.ldq.study.thread.synchroniz.Reentrant;

/**
 * 可重入粒度测试：递归调用本方法
 * 也就是synchronized修饰的方法可重入
 */
public class SynchronizedRecursion {
    int a = 0;

    public static void main(String[] args) {
        SynchronizedRecursion recursion = new SynchronizedRecursion();
        recursion.method();
        System.out.println("+++++++++++++++");
        recursion.method1();
        System.out.println("================");
        recursion.method2();
    }

    /**
     * method是递归调用自己
     * 验证同一个方法中，可重入
     */
    private synchronized void method() {
        System.out.println("this is method! a = " + a);
        if (a == 0) {
            a++;
            method();
        }
    }

    /**
     * method1中调用了method方法
     * 验证不同方法中，可重入
     */
    private synchronized void method1() {
        System.out.println("this is method1!");
        method();
    }

    /**
     * method2中调用了method方法
     * 验证 不同一个方法中，可重入
     */
    private void method2() {
        System.out.println("this is method2!");
        method();
    }

}
