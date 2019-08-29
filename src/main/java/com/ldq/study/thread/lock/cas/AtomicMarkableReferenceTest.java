package com.ldq.study.thread.lock.cas;

import java.util.concurrent.atomic.AtomicMarkableReference;

/**
 * AtomicMarkableReference利用一个boolean类型的标记来记录，只能记录它改变过，不能记录改变的次数
 */
public class AtomicMarkableReferenceTest {
    private final static String A = "A";
    private final static String B = "B";
    //初始值状态A-false
    private final static AtomicMarkableReference<String> ar = new AtomicMarkableReference<>(A, false);


    //expectedReference表示我们传递的预期值
    //newReference表示将要更改的新值
    //expectedMark表示传递的预期boolean类型标记
    //newMark表示将要更改的boolean类型标记的新值。
    //底层实现逻辑
//    public boolean compareAndSet(V expectedReference,
//                                 V newReference,
//                                 boolean expectedMark,
//                                 boolean newMark) {
//        Pair<V> current = pair;
//        return
//                expectedReference == current.reference &&
//                        expectedMark == current.mark &&
//                        ((newReference == current.reference &&
//                                newMark == current.mark) ||
//                                casPair(current, Pair.of(newReference, newMark)));
//    }

    /**
     * 通过把操作的对象和一个boolean类型的标记封装成Pair，
     * 而Pair有被volatile修饰，说明只要更改其他线程立刻可见，
     * 而只有Pair中的两个成员变量都相等。来解决CAS中ABA的问题的
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
            if (ar.compareAndSet(A, B, false, true)) {
                System.out.println("我是线程1,我成功将A改成了B");
            }
        }).start();

        /**
         * 第一个获取CPU资源执行，应为期望值和内存值一致
         * 内存值A-false
         * 期望值A-false
         * 修改值B-true
         */
        new Thread(() -> {
            if (ar.compareAndSet(A, B, false, true)) {
                System.out.println("我是线程2,我成功将A改成了B");
            }
        }).start();

        /**
         * 第二个活得CPU资源
         * 内存值B-isMarked()= B-true
         * 期望值B-true
         * 修改值A-true
         */
        new Thread(() -> {
            if (ar.compareAndSet(B, A, ar.isMarked(), true)) {
                System.out.println("我是线程3,我成功将B改成了A");
            }
        }).start();
    }
}
