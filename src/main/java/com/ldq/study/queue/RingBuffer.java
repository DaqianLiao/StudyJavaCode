package com.ldq.study.queue;

import sun.misc.Contended;

import java.util.concurrent.atomic.AtomicInteger;

public class RingBuffer<T> {

    private int bufferSize;
    private AtomicRangeInteger index;
    private final T[] buffer;

    public RingBuffer(int bufferSize) {
        this.bufferSize = bufferSize;
        this.index = new AtomicRangeInteger(0, bufferSize);
        this.buffer = (T[]) new Object[bufferSize+1];
    }

    public final void offer(final T data) {
        buffer[index.incrementAndGet()] = data;
    }

    public final T poll(int index) {
        T tmp = buffer[index];
        buffer[index] = null;
        System.out.println("tmp = " + tmp);
        return tmp;
    }

    public int getBufferSize() {
        return bufferSize;
    }

    /**
     * 在环形队列上保证线程安全地获取数组下标.线程安全地自增我们想到了AtomicInteger，很容易写出如下代码
     */
    public class AtomicRangeInteger extends Number {

        //    AtomicRangeInteger对象中存在三个属性，value，startValue，endValue，value是经常变化的，
//    startValue，endValue是不会变化，所以当value经常变化会导致读取startValue，endValue时不会命中cpu缓存，性能有所下降，
//    我们使用jdk8的注解@Contended来填充value所在行的缓存。
        @Contended
        private final AtomicInteger atomicInteger;
        private final int startValue;
        private final int endValue;

        public AtomicRangeInteger(int startValue, int endValue) {
            this.atomicInteger = new AtomicInteger(startValue);
            this.startValue = startValue;
            this.endValue = endValue;
        }

        public final int incrementAndGet() {
            int next;

//        生产者获取下一个可用的index，直接在当前基础上调用incrementAndGet进行加1操作，该操作是原子的，
//        故拿到的一定是没有被其他线程占用的index
//        获取上一步的返回值，该返回值有可能超过ring buffer的最大下标值，如果超过则将其置为startValue，这一步使用compareAndSet，
//        可能会失败，如果失败说明有其他线程做了该操作，故可以再调用一次incrementAndGet获取下一个下标
            do {
                next = atomicInteger.incrementAndGet();
                if (next > endValue && atomicInteger.compareAndSet(next, startValue)) {
                    return startValue;
                }
            } while (next > endValue);

            System.out.println("startValue = " + startValue + ", next = " + next + ", endvalue = "
                    + endValue + ", atomic = " + atomicInteger.intValue());
            return next;
        }

        public final int get() {
            return atomicInteger.intValue();
        }

        @Override
        public int intValue() {
            return atomicInteger.intValue();
        }

        @Override
        public long longValue() {
            return atomicInteger.intValue();
        }

        @Override
        public float floatValue() {
            return atomicInteger.intValue();
        }

        @Override
        public double doubleValue() {
            return atomicInteger.intValue();
        }
    }

    public static void main(String[] args) {
        RingBuffer<String> ringBuffer = new RingBuffer<>(4);
        ringBuffer.offer("a");
        ringBuffer.offer("b");
        ringBuffer.offer("c");
        ringBuffer.offer("d");
        ringBuffer.offer("e");
        ringBuffer.poll(0);
        ringBuffer.poll(1);
        ringBuffer.poll(2);
        ringBuffer.poll(3);
    }
}
