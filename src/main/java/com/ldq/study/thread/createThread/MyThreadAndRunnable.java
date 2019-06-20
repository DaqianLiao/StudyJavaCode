package com.ldq.study.thread.createThread;

public class MyThreadAndRunnable extends Thread implements Runnable {
    public void run(){
        System.out.println("this is myThreadAndRunnable which extends Thread implements Runnable");
    }
}
