package com.ldq.study.thread.printChange;

/**
 * 只使用volatile关键字，此时线程会不断的执行，每次执行只有当flag复合条件的情况下
 * 才会进入到打印数据阶段，线程频繁的切换。
 */
public class volatileThread {

    static int maxInt = 100;
    static volatile int index = 0;
    static volatile boolean flag = true;

    static class MyRun1 implements Runnable {

        @Override
        public void run() {

            while (index < maxInt) {
                System.out.println(Thread.currentThread().getName() +
                        " is ready to run! now flag = " + flag + ", index = " + index);
                if (flag) {
                    System.out.println(Thread.currentThread().getName() + " is print:" + index++);
                    flag = false;
                }
            }
        }
    }

    static class MyRun2 implements Runnable {
        @Override
        public void run() {
            while (index < maxInt) {
                System.out.println(Thread.currentThread().getName() +
                        " is ready to run! now flag = " + flag + ", index = " + index);

                if (!flag) {
                    System.out.println(Thread.currentThread().getName() + " is print: " + index++);
                    flag = true;
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRun1());
        Thread t2 = new Thread(new MyRun2());
        t1.start();
        t2.start();
    }

}
