package com.ldq.study.thread.FutureDemo;

import java.util.concurrent.Callable;

public class FutureCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
//       return catchException();
        return throwException();
    }

    private String catchException() throws Exception {
        String done = "init";
        int index = 1;

        while (index <= 10) {
            try {
                Thread.sleep(2 * 1000);
                System.out.println("it runs " + index + " times");
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            index++;
        }
        done = "done";
        return done;
    }

    private String throwException() throws Exception {
        String done = "init";
        int index = 1;

        while (index <= 10) {
            Thread.sleep(2 * 1000);
            System.out.println("it runs " + index + " times");
            index++;
        }
        done = "done";
        return done;
    }

}
