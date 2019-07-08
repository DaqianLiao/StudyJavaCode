package com.ldq.study.thread.synchroniz;


public class SyncThread implements Runnable {
    static SyncThread syncThread = new SyncThread();
    static int i = 0;

    @Override
    public void run() {
        for (int i1 = 0; i1 < 10000; i1++) {
            /**
             * 这个操作不是原子的，会被拆分为三步
             * 1/从内存中读取i的值
             * 2/对i的值+1
             * 3/将i的值写会内存
             */
            i++;
        }
    }

    /**
     * 由于线程不安全，导致得到结果不是预期的结果
     * 具体逻辑，自己好好捋清楚
     * @throws InterruptedException
     */
    public static void testCode() throws InterruptedException {
        Thread thread1 = new Thread(syncThread);
        Thread thread2 = new Thread(syncThread);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("count = " + i);
    }

    public static void main(String[] args) throws InterruptedException {
        testCode();
    }
}
