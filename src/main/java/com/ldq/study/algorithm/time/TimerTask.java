package com.ldq.study.algorithm.time;

public interface TimerTask {
    void run(Timeout timeout, String argv) throws Exception;
}
