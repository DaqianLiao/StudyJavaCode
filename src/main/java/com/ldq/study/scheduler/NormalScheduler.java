package com.ldq.study.scheduler;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NormalScheduler {
    /**
     * 休眠实现定时任务,这种方式比较傻瓜化了，只能按固定频率运行，不能指定具体运行的时间。
     */
    public static void sleepTask(){
        new Thread(()->{
            System.out.println("start job");
            while (true){
                System.out.println("thread start scheduler!");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * timer定时任务
     * 这种实现方式比较简单，可以指定首次执行的延迟时间、首次执行的具体日期时间，以及执行频率，能满足日常需要。
     *
     * 另外，需要注意的是，Timer 是线程安全的，因为背后是单线程在执行所有任务。
     *
     * Timer 也会有一些缺陷：
     *
     * Timer 是单线程的，假如有任务 A,B,C，任务 A 如果执行时间比较长，那么就会影响任务 B,C 的启动和执行时间，如果 B,C 执行时间也比较长，那就会相互影响；
     * Timer 不会捕获异常，如果 A,B,C 任何一个任务在执行过程中发生异常，就会导致 TImer 整个定时任务停止工作；
     * Timer 是基于绝对时间调度的，而不是基于相对时间，所以它对系统时间的改变非常敏感；
     */
    public static void timerTask() throws InterruptedException{
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("TimerTask do thing");
                try {

                    Thread.sleep(10*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // 第一次任务延迟时间
        long delay = 2000;

        // 任务执行频率
        long period = 3 * 1000;

        // 开始调度
        timer.schedule(task, delay, period);

        // 指定首次运行时间
// timer.schedule(timerTask, DateUtils.addSeconds(new Date(), 5), period);

        Thread.sleep(20000);

        // 终止并移除任务
        timer.cancel();
        timer.purge();

    }


    /**
     * 线程池定时任务
     * 这是一个按固定频率调度的任务，创建了 10 个核心线程数，首次执行延迟 2 秒，后续每 3 秒执行一次。
     */
    public static void poolTask(){
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(10);

        pool.scheduleAtFixedRate(() -> {
            System.out.println("ScheduledExecutorService do job!");
        }, 2000, 3000, TimeUnit.MILLISECONDS);
    }
    public static void main(String[] args) throws InterruptedException {
        sleepTask();

        timerTask();

        poolTask();

    }
}
