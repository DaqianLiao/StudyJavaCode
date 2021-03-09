package com.ldq.study.thread.status;

public class FlagThread extends Thread{

    public long i = 0;
    public boolean flag = true;
    @Override
    public void run(){
        while (flag){
            i= i +1;
//            System.out.println("i = " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FlagThread flagThread = new FlagThread();
        flagThread.start();

        Thread.sleep(2000);
//        System.out.println("first = " + flagThread.i);
//        System.out.println(flagThread.isAlive());
//        Thread.sleep(2000);
        flagThread.flag = false;
        System.out.println("flagThread.flag = " + flagThread.flag);
        System.out.println("second = "+ flagThread.i);
//        System.out.println(flagThread.isAlive());
        System.out.println("three = "+ flagThread.i);
    }
}
