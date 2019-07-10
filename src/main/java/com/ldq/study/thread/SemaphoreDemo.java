package com.ldq.study.thread;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {

    //设置许可证的最大数量，也就意味着同时允许N个线程执行
    private static final Semaphore semaphore = new Semaphore(3);
    private static final ThreadPoolExecutor threadPool =
            new ThreadPoolExecutor(5, 10,
                    60, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

    private static class InformationThread extends Thread {
        private final String name;
        private final int age;

        public InformationThread(String name, int age) {
            this.name = name;
            this.age = age;
        }

        /**
         * 只要许可证>0，就表示允许有线程执行
         * 场景：停车场有3个车位，最多允许3台车同时进入，当车停满了，就拦住后面所有车
         *      直到有车出来，有空车位时，才允许进入新的车辆
         */
        public void run() {
            try {
                //获取许可证
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + ":大家好，我是" + name + "我今年" + age + "岁当前时间为：" + System.currentTimeMillis());
                Thread.sleep(new Random().nextInt(100) * 100);
                System.out.println(name + "要准备释放许可证了，当前时间为：" + System.currentTimeMillis());

                System.out.println("当前可使用的许可数为：" + semaphore.availablePermits());
                //释放许可证
                semaphore.release();
                System.out.println("释放许可证后，可使用的许可数为：" + semaphore.availablePermits());


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String[] name = {"李明", "王五", "张杰", "王强", "赵二", "李四", "张三"};
        int[] age = {26, 27, 33, 45, 19, 23, 41};
        for (int i = 0; i < name.length; i++) {
            Thread t1 = new InformationThread(name[i], age[i]);
            threadPool.execute(t1);
        }
    }

}
