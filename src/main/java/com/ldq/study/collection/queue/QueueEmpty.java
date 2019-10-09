package com.ldq.study.collection.queue;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 在判断queue中是否包含元素（是否为空）的时候，最好使用isEmpty
 */
public class QueueEmpty {
    private static ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<Integer>();
    private static int count1 = 100000;
    private static int count2 = 2;

    private static CountDownLatch latch = new CountDownLatch(count2);

    static {
        for (int i = 0; i < count1; i++) {
            queue.add(i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        ExecutorService service = Executors.newFixedThreadPool(count2);
        for (int i = 0; i < count2; i++) {
            service.execute(new Poll());
        }
        latch.await();
        long end = System.currentTimeMillis();
        System.out.println("cost time = " + (end - start) + "ms");
    }

    static class Poll implements Runnable {

        @Override
        public void run() {
            //isEmpty 运行耗时短
//            while (!queue.isEmpty()) {
            //size() 运行耗时长，因为size判断的时候，需要遍历集合，因此导致耗时较长
            while (queue.size() > 0) {
                System.out.println("poll num = " + queue.poll());
            }
            latch.countDown();
        }
    }
}
