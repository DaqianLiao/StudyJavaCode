package com.ldq.study.queue;

import sun.misc.Contended;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class MyLongAdder {

    public static void main(String[] args) {


    }
/**
 * 测试方法
 */

    /**
     * --------------具体类----------------------
     * 基础逻辑，实现分段原子性
     */
    class LongAdderV0 {
        int coreSize;
        private AtomicLong[] intArray;

        public LongAdderV0(int coreSize) {
            this.coreSize = coreSize;
            this.intArray = new AtomicLong[coreSize];
            for (int i = 0; i < coreSize; i++) {
                intArray[i] = new AtomicLong(0);
            }
        }

        //取模操作耗时
        public void increase() {
            int index = (int) (Thread.currentThread().getId() % coreSize);
            intArray[index].incrementAndGet();
        }
    }

    class LongAdderV1 {
        int coreSize;
        private AtomicLong[] intArray;

        public LongAdderV1(int coreSize) {
            this.coreSize = coreSize;
            this.intArray = new AtomicLong[coreSize];
            for (int i = 0; i < coreSize; i++) {
                intArray[i] = new AtomicLong(0);
            }
        }

        //取模操作，必须coreSize为 2 的 n次方
        public void increase() {
            int index = (int) (Thread.currentThread().getId() & (coreSize - 1));
            intArray[index].incrementAndGet();
        }
    }

    //    取消伪共享
    class LongAdderV2 {
        private class AtomicLongWrap {
            @Contended
            private final AtomicLong value = new AtomicLong(0);
        }

        int coreSize;
        private AtomicLongWrap[] intArray;

        public LongAdderV2(int coreSize) {
            this.coreSize = coreSize;
            this.intArray = new AtomicLongWrap[coreSize];
            for (int i = 0; i < coreSize; i++) {
                intArray[i] = new AtomicLongWrap();
            }
        }

        //取模操作，必须coreSize为 2 的 n次方
        public void increase() {
            int index = (int) (Thread.currentThread().getId() & (coreSize - 1));
            intArray[index].value.incrementAndGet();
        }
    }

    //V0到V2版本均使用了线程id作为hash值来散列到不同的槽点，线程id生成后不会改变，这样就会导致每次执行的测试可能结果都不太一样，
    // 如果比较聚焦，性能必然会很差，当线程数增多后必然会造成更多的冲突，有没有更好的hash算法

    class LongAdderV3 {
        private class AtomicLongWrap {
            @Contended
            private final AtomicLong value = new AtomicLong(0);
        }

        int coreSize;
        private AtomicLongWrap[] intArray;

        public LongAdderV3(int coreSize) {
            this.coreSize = coreSize;
            this.intArray = new AtomicLongWrap[coreSize];
            for (int i = 0; i < coreSize; i++) {
                intArray[i] = new AtomicLongWrap();
            }
        }

        //取模操作，必须coreSize为 2 的 n次方
        public void increase() {
            int index = (int) (Thread.currentThread().hashCode() & (coreSize - 1));
            intArray[index].value.incrementAndGet();
        }
    }
}
