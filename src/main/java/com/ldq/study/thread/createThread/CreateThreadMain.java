package com.ldq.study.thread.createThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CreateThreadMain {

    public static void firstThread(){
        MyThread thread = new MyThread();
        thread.start();
    }

    public static void secondThread(){
        MyRunnable runnable = new MyRunnable();
        new Thread(runnable).start();
    }

  public static void thirdThread(){
      MyThreadAndRunnable thread = new MyThreadAndRunnable();
      thread.start();
  }


  public static void fourThread() throws ExecutionException, InterruptedException {
      MyCallable callable = new MyCallable();
      FutureTask<Integer> futureTask = new FutureTask<>(callable);
      Thread thread = new Thread(futureTask);
      thread.start();
      System.out.println("result = " + futureTask.get());

  }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        firstThread();
        secondThread();
        thirdThread();
        fourThread();
    }
}
