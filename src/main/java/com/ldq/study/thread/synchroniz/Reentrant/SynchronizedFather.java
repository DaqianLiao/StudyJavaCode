package com.ldq.study.thread.synchroniz.Reentrant;

/**
 * 可重入粒度测试： 调用父类方法
 *
 */
public class SynchronizedFather {

    public synchronized void dothing(){
        System.out.println("Im father method");
    }
}

class SynchronizedSon extends SynchronizedFather {
    public synchronized void dothing(){
        System.out.println("Im son method");
        super.dothing();
    }

    public static void main(String[] args) {
        SynchronizedSon son = new SynchronizedSon();
        son.dothing();
    }
}
