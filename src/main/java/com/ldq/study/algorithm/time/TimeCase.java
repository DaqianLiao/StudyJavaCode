package com.ldq.study.algorithm.time;

import org.junit.Test;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimeCase {


    @Test
    public  void task1() throws InterruptedException {
        Timer timer = new Timer();
        System.out.println("start = " + new Date());
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("timer1 = " + new Date());
            }
        }, 1000);

        Thread.sleep(Integer.MAX_VALUE);
    }

    /**
     * 如果任务执行时间过长，TimerTask会出现延迟执行的情况。
     * 第一任务在1000ms执行了4000ms，第二个任务定时在2000ms开始执行。
     * 由于第一个任务要执行4000，所以第二个任务实际在5000ms开始执行。
     * 这是由于Timer是单线程，且顺序执行提交的任务
     * @throws InterruptedException
     */
    @Test
    public  void task2() throws InterruptedException {
        Timer timer = new Timer();
        System.out.println("start = " + new Date());
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("timer1 = " + new Date());
                try {
                    TimeUnit.SECONDS.sleep(4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 1000);

//        timer是单线程提交任务，因此会依赖前一个任务完成时间
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("timer2 = " + new Date());
            }
        }, 1000);

        Thread.sleep(Integer.MAX_VALUE);
    }

    /**
     * 如果执行任务抛出异常，Timer是不会执行后面的任务的
     * @throws InterruptedException
     */
    @Test
    public  void task3() throws InterruptedException {
        Timer timer = new Timer();
        System.out.println("start = " + new Date());
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("timer1 = " + new Date());
                try {
                    TimeUnit.SECONDS.sleep(4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    throw new RuntimeException("aaa");
                }
            }
        }, 1000);

//        timer是单线程提交任务，因此会依赖前一个任务完成时间
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("timer2 = " + new Date());
            }
        }, 1000);

        Thread.sleep(Integer.MAX_VALUE);
    }


    /**
     * 任务一在1000ms执行，4000ms后结束。
     * 任务二在2000ms执行，4000ms后结束，任务二不会等任务一执行完成后执行，抛出异常也会执行任务二
     */
    @Test
    public void task4() throws InterruptedException {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        System.out.println("start = " + new Date());
        executorService.schedule(() -> {
            try {
                System.out.println("task1 = " + new Date());
                TimeUnit.SECONDS.sleep(4);
                System.out.println("task1 end = " + new Date());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },1000,TimeUnit.MILLISECONDS);
        executorService.schedule(() -> {
            try {
                System.out.println("task2 = " + new Date());
                TimeUnit.SECONDS.sleep(4);
                System.out.println("task2 end = " + new Date());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },2000,TimeUnit.MILLISECONDS);

        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
    }

    @Test
    public void task5() throws InterruptedException {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        System.out.println("start = " + new Date());
        executorService.schedule(() -> {
            try {
                System.out.println("task1 = " + new Date());
                TimeUnit.SECONDS.sleep(4);
                System.out.println("task1 end = " + new Date());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            throw new RuntimeException("aaa");
        },1000,TimeUnit.MILLISECONDS);

        executorService.schedule(() -> {
            try {
                System.out.println("task2 = " + new Date());
                TimeUnit.SECONDS.sleep(4);
                System.out.println("task2 end = " + new Date());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },2000,TimeUnit.MILLISECONDS);

        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
    }

}
