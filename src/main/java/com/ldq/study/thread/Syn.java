package com.ldq.study.thread;

public class Syn {
    private static int cnt = 0;

    public static synchronized  void inc(){
        cnt++;
    }

    static class IncreaseTask implements Runnable {
        @Override
        public void run() {
            for (int j = 0; j < 1000; j++) {
                inc();
            }
        }

        private synchronized void inc() {
            cnt++;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        int num = 10;
        IncreaseTask increaseTask = new IncreaseTask();
        Thread t1 = new Thread(increaseTask);
        Thread t2 = new Thread(increaseTask);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("cnt = " + cnt);
    }
}
