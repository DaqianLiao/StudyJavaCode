package com.ldq.study.thread.lock.cas;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * AtomicStampedReference利用一个int类型的标记来记录，它能够记录改变的次数
 */
public class AtomicStampedReferenceTest {
    private final static String A = "A";
    private final static String B = "B";
    private static AtomicInteger ai = new AtomicInteger(1);
    private final static AtomicStampedReference<String> ar = new AtomicStampedReference<>(A, 1);

    //expectedReference表示我们传递的预期值
    //newReference表示将要更改的新值
    //expectedStamp 表示传递的预期 int 类型标记
    //newStamp 表示将要更改的 int 类型标记的新值。
    //底层实现逻辑
//    public boolean compareAndSet(V expectedReference,
//                                 V newReference,
//                                 int expectedStamp,
//                                 int newStamp) {
//        Pair<V> current = pair;
//        return
//                expectedReference == current.reference &&
//                        expectedStamp == current.stamp &&
//                        ((newReference == current.reference &&
//                                newStamp == current.stamp) ||
//                                casPair(current, Pair.of(newReference, newStamp)));
//    }

    /**
     * 通过把操作的对象和一个boolean类型的标记封装成Pair，
     * 而Pair有被volatile修饰，说明只要更改其他线程立刻可见，
     * 而只有Pair中的两个成员变量都相等。来解决CAS中ABA的问题的
     *
     * @param args
     */
    public static void main(String[] args) {
        /**
         * 第三个获得资源，但是由于不匹配，修改不了
         * 内存值A-true
         * 期望值A-false
         * 修改值B-true
         */
        new Thread(() -> {
            try {
                Thread.sleep(Math.abs((int) (Math.random() * 100)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("我是线程1,内存值：" + ar.getReference() + ar.getStamp());
            System.out.println("我是线程1,期望值：" + A + 1);
            System.out.println("我是线程1,修改值：" + B + 2);

            if (ar.compareAndSet(A, B, 1, 2)) {
                System.out.println("我是线程1,我成功将A改成了B");
            }
        }).start();

        /**
         * 第一个获取CPU资源执行，应为期望值和内存值一致
         * 内存值A-1
         * 期望值A-false
         * 修改值B-true
         */
        new Thread(() -> {
            int expected = ai.get();
            int increment = ai.incrementAndGet();
            System.out.println("我是线程2,内存值：" + ar.getReference() + ar.getStamp());
            System.out.println("我是线程2,期望值：" + A + expected);
            System.out.println("我是线程2,修改值：" + B + increment);
            if (ar.compareAndSet(A, B, expected, increment)) {
                System.out.println("我是线程2,我成功将A改成了B");
            }
        }).start();

        new Thread(() -> {
            int expected = ai.get();
            int increment = ai.incrementAndGet();
            System.out.println("我是线程3,内存值：" + ar.getReference() + ar.getStamp());
            System.out.println("我是线程3,期望值：" + B + expected);
            System.out.println("我是线程3,修改值：" + A + increment);

            if (ar.compareAndSet(B, A, expected, increment)) {
                System.out.println("我是线程3,我成功将B改成了A");
            }
        }).start();
    }
}
