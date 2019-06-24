package com.ldq.study.thread.FutureDemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureMain {
    public static void getFutureResult() {
        FutureCallable futureCallable = new FutureCallable();
        FutureTask<String> future = new FutureTask<>(futureCallable);
        Thread thread = new Thread(future);
        thread.start();
        //thread runnnig 20s
        try {
            while (!future.isDone()) {
                System.out.println("thread is running");

                Thread.sleep(1000);
            }
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void stopThread() {
        FutureCallable futureCallable = new FutureCallable();
        FutureTask<String> future = new FutureTask<>(futureCallable);
        Thread thread = new Thread(future);
        thread.start();
        try {
            Thread.sleep(10 * 1000);
            future.cancel(true);
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        getFutureResult();
        stopThread();
    }
}
