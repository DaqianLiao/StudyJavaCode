package com.ldq.study.algorithm.time;

public interface Timeout {
    Timer timer();
    TimerTask task();
    boolean isExpired();
    boolean isCancelled();
    boolean cancel();
}
