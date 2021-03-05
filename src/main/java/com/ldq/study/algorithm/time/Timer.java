package com.ldq.study.algorithm.time;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface Timer {
    Timeout newTimeout(TimerTask task, long delay, TimeUnit unit, String argv);
    Set<Timeout> stop();
}
