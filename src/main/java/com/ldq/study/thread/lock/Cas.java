package com.ldq.study.thread.lock;

/**
 * CAS(Compare And Set)算法是硬件对于并发操作的支持，是一种无锁的非阻塞算法的实现。
 * CAS算法保证同时访问时只有一个线程能进来，当多个线程同时并发访问操作共享数据的时候，
 * 有且只有一个能够成功，其他的线程都会失败。
 * CAS有3个操作数，内存值V，旧的预期值A，要修改的新值B。
 * 当且仅当预期值A和内存值V相同时，将内存值V修改为B，否则什么都不做。类似于乐观锁
 */
public class Cas {

    public static void main(String[] args) {
        final CompareAndSwap cas = new CompareAndSwap();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                int expectedValue = cas.get();
                System.out.println(Thread.currentThread().getName() + " inner value = " + expectedValue);
                boolean b = cas.compareAndSet(expectedValue, (int) (Math.random() * 101));
                System.out.println(Thread.currentThread().getName() + " update value " + b);
            }).start();
        }

    }


    /**
     * CAS有3个操作数，内存值V，旧的预期值A，要修改的新值B。
     * 当且仅当预期值A和内存值V相同时，将内存值V修改为B，否则什么都不做
     */
    static class CompareAndSwap {
        //内存值
        private int value;

        //获取内存值
        public synchronized int get() {
            return value;
        }

        /**
         * 输入预期值，和更新值
         * 输出内存值
         *
         * @param expectedValue
         * @param newValue
         * @return
         */
        public synchronized int compareAndSwap(int expectedValue, int newValue) {
            int oldValue = value;
//            如果内存值 == 预期值，则将内存值更新为更新值
            if (oldValue == expectedValue) {
                this.value = newValue;
            }

            return oldValue;
        }

        //        判断是否更新成功
        public synchronized boolean compareAndSet(int expectedValue, int newValue) {
            return expectedValue == compareAndSwap(expectedValue, newValue);
        }
    }
}
