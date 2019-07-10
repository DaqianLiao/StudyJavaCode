package com.ldq.study.thread.threadLocal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * threadlocal 使用实验
 * 使用场景：
 *     当线程中需要独立使用到变量的时候，不受多个线程相互影响
 */
public class ThreadLocalDemo {
    private static ThreadLocal<Integer> numLocal = new ThreadLocal<>();

    /**
     * DateFormat线程不安全，因此可以让每个线程都生成一个自己的对象
     *
     */
    private static ThreadLocal<DateFormat> local =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    public static Date parse(String dateStr) {
        Date date = null;
        try {
            date = local.get().parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static int add10(int num) {
        //将变量设置为线程私有变量
        numLocal.set(num);

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return numLocal.get() + 10;
    }


    public static void testAddNum() {
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            int num = i;
            service.execute(() -> System.out.println(num + " " + add10(num)));

        }
        service.shutdown();
    }

    public static void testDateParse() {
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 10; i < 20; i++) {
            String date = "2019-03-" + i + " 01:00:00";
            System.out.println("date = " + date);
            service.execute(() -> System.out.println(date + " 转化为日期类型： " + parse(date)));

        }
        service.shutdown();
    }

    public static void main(String[] args) {
        testAddNum();
        testDateParse();
    }
}
