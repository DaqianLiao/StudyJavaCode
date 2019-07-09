package com.ldq.study.thread.synchroniz.Reentrant;

/**
 * 反编译代码，可以看到monitorenter和monitorexit
 *
 */
public class CompilerCode {
    private Object lock = new Object();
    private int i = 0;

    public void insert(String thread) {
        synchronized (lock) {
            i++;
        }
    }

    public static void main(String[] args) {
        new CompilerCode();
    }

}
