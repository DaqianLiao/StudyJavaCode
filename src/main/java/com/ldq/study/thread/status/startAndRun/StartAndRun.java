package com.ldq.study.thread.status.startAndRun;

public class StartAndRun {
    static class Runner1 implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("进入Runner1运行状态---------" + i);
            }
        }
    }

    static class Runner2 implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("进入Runner2运行状态---------" + i);
            }
        }
    }

    /**
     * 两个线程交替执行，
     * 线程提交到后台，异步执行
     */
    public static void start() {
        Runner1 r1 = new Runner1();
        Runner2 r2 = new Runner2();

        Thread thread1 = new Thread(r1);
        Thread thread2 = new Thread(r2);

        thread1.start();
        thread2.start();
    }

    /**
     * 线程按照顺序执行，
     * thread1 先执行所有逻辑，thread2才会执行
     */
    public static void run() {
        Runner1 r1 = new Runner1();
        Runner2 r2 = new Runner2();

        Thread thread1 = new Thread(r1);
        Thread thread2 = new Thread(r2);

        thread1.run();
        thread2.run();
    }

    public static void main(String[] args) {
        //每次运行其中一个
//       start();
       run();
    }
}
