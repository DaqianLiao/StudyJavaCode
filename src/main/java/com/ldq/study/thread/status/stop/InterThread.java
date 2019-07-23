package com.ldq.study.thread.status.stop;

import java.util.concurrent.TimeUnit;

public class InterThread {


    static class RunnableA implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "--" + i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        testInter();
        System.out.println("===========");
        testIsInter();
        System.out.println("===========");
        testInterrupted();
    }

    /**
     * thread.isInterrupted()
     * 判断调用线程是否被中断，不会清除调用线程的中断状态
     *
     * @throws InterruptedException
     */
    private static void testIsInter() throws InterruptedException {
        Runnable target = new RunnableA();
        Thread thread = new Thread(target);
        thread.start();
        thread.interrupt();
        System.out.println("thread first  interrupted? " + thread.isInterrupted());
        System.out.println("thread second interrupted? " + thread.isInterrupted());
        System.out.println("main is interrupted? " + Thread.currentThread().isInterrupted());
        TimeUnit.SECONDS.sleep(5);
    }

    /**
     * thread.interrupted()
     * 判断当前线程是否被中断，同时清除调用线程的中断状态
     *
     * @throws InterruptedException
     */
    private static void testInterrupted() throws InterruptedException {
        Runnable target = new RunnableA();
        Thread thread = new Thread(target);
        thread.start();
        thread.interrupt();
        //判断当前线程，由于main线程没有被中断，false
        System.out.println("thread first  interrupted? " + thread.interrupted());
        //判断thread线程，true
        System.out.println("thread second isInterrupted? " + thread.isInterrupted());
        //此时中断main线程
        Thread.currentThread().interrupt();
        //判断main线程是否中断， true
        System.out.println("main is isInterrupted? " + Thread.currentThread().isInterrupted());
        //main 线程中断，true
        System.out.println("main is interrupted? " + thread.interrupted());
        //main中断状态被清除，false
        System.out.println("main is interrupted? " + Thread.currentThread().interrupted());
        TimeUnit.SECONDS.sleep(5);
    }

    /**
     * thread.interrupt();
     * 该方法会发送中断信号给线程，线程接收中断信号
     * 线程依然会正常运行
     */
    private static void testInter() throws InterruptedException {
        Runnable target = new RunnableA();
        Thread thread = new Thread(target);
        thread.start();
        thread.interrupt();
        TimeUnit.SECONDS.sleep(5);
    }
}
