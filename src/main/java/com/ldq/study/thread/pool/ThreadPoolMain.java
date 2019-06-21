package com.ldq.study.thread.pool;

public class ThreadPoolMain {
    public static void main(String[] args) {
        System.out.println("---------------------------------");
        CacheThreadPool.execute();

        System.out.println("---------------------------------");
        FixThreadPool.execute();

        System.out.println("---------------------------------");
        SingleThreadPool.execute();

        System.out.println("---------------------------------");
        ScheduledThreadPool.execute();
    }
}
