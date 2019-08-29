package com.ldq.study.thread.lock.cas;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 1：ABA问题，也就是说从A变成B，然后就变成A，但是并不能说明其他线程并没改变过它，
 * 利用CAS就发现不了这种改变。
 * 2：由于CAS失败后会继续重试，导致一致占用着CPU。
 */
public class AtomicReferenceTest {
    private final static String A = "A";
    private final static String B = "B";
    private final static AtomicReference<String> ar = new AtomicReference<>(A);

    /**
     * 线程1准备利用CAS修改变量值A，但是在修改之前，其他线程已经将A变成了B，然后又变成A，
     * 即A->B->A,线程1执行CAS的时候发现仍然为A，所以CAS会操作成功，
     * 但是其实目前这个A已经是其他线程修改的了，但是线程1并不知道，
     * 最终内存值变成了B，这就导致了ABA问题
     *
     * @param args
     */
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Thread.sleep(Math.abs((int) (Math.random() * 100)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (ar.compareAndSet(A, B)) {
                System.out.println("我是线程1,我成功将A改成了B");
            }
        }).start();
        new Thread(() -> {
            if (ar.compareAndSet(A, B)) {
                System.out.println("我是线程2,我成功将A改成了B");
            }
        }).start();
        new Thread(() -> {
            if (ar.compareAndSet(B, A)) {
                System.out.println("我是线程3,我成功将B改成了A");
            }
        }).start();
    }
}
