package com.ldq.study.thread.lock;


public class AtomicInt {
    public static void main(String[] args) {
        AtomicDemo ad = new AtomicDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(ad).start();
        }
    }


    static class AtomicInteger {
        private volatile int value;

        public AtomicInteger(int value) {
            this.value = value;
        }

        // 获取内存值
        public synchronized int get() {
            return value;
        }

        /**
         * 进入死循环，只有当执行成功的时候，才会返回
         * @return
         */
        public synchronized int getAndIncrement() {
            for (; ; ) {
                int current = get();
                int next = current + 1;
                if (compareAndSet(current, next))
                    return next;
            }
        }

        // 比较
        public synchronized int compareAndSwap(int expectedValue, int newValue) {
            int oldValue = value;
            if (oldValue == expectedValue) {
                this.value = newValue;
            }
            return oldValue;
        }

        public synchronized boolean compareAndSet(int expectedValue, int newValue) {
            return expectedValue == compareAndSwap(expectedValue, newValue);
        }
    }

    static class AtomicDemo implements Runnable {
        private AtomicInteger serialNumber = new AtomicInteger(0);

        @Override
        public void run() {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + getSerialNumber());
        }

        public int getSerialNumber() {
            return serialNumber.getAndIncrement();
        }
    }
}