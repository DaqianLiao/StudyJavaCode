package com.ldq.study.util.lang3;

import org.apache.commons.lang3.time.*;
import org.junit.Test;

import java.util.Date;

import static java.lang.System.out;

public class DateTest {
    @Test
    public void name() throws Exception {
        Date now = new Date();
        String time = DateFormatUtils.format(now, "yyyy-MM-dd HH:mm:ss.SSS");
        out.println(time + ":" + now.getTime());
        Date date = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss.SSS").parse(time);
        out.println(date.getTime());
    }

    @Test
    public void duration() throws Exception {
        out.println(DurationFormatUtils.formatDuration(24 * 3600 * 1000, "H"));
    }

    @Test
    public void date() throws Exception {

    }

    @Test
    public void stopWatch() throws Exception {
        StopWatch stopWatch = new StopWatch();
        out.println(stopWatch.getTime());
        stopWatch.start();
        int i = 0;
        while (i < 10) {
            out.println("now:" + stopWatch.getTime());
            i++;
            Thread.sleep(1000);
        }
        //记录第一个时刻
        stopWatch.split();
        i = 0;
        while (i < 10) {
            out.println("now:" + stopWatch.getTime());
            out.println("split1:" + stopWatch.getSplitTime());
            i++;
            Thread.sleep(1000);
        }
        //记录第二个时刻
        stopWatch.split();
        i = 0;
        while (i < 10) {
            out.println("now:" + stopWatch.getTime());
            out.println("split2:" + stopWatch.getSplitTime());
            i++;
            Thread.sleep(1000);
        }
        //记录第三个时刻
        stopWatch.split();
        i = 0;
        while (i < 10) {
            out.println("now:" + stopWatch.getTime());
            out.println("split3:" + stopWatch.getSplitTime());
            i++;
            Thread.sleep(1000);
        }
        //非记录状态
        stopWatch.unsplit();
        i = 0;
        while (i < 10) {
            out.println("now:" + stopWatch.getTime());
            try {
                out.println("unsplit:" + stopWatch.getSplitTime());//这句会挂，非split状态无法获取splitTime
            } catch (Exception e) {
                out.println("unsplit:" + e.getMessage());
            }
            i++;
            Thread.sleep(1000);
        }
        //暂停
        stopWatch.suspend();
        i = 0;
        while (i < 10) {
            out.println("suspend:" + stopWatch.getTime());
            i++;
            Thread.sleep(1000);
        }
        //恢复
        stopWatch.resume();
        i = 0;
        while (i < 10) {
            out.println("resume:" + stopWatch.getTime());
            i++;
            Thread.sleep(1000);
        }
    }
}
