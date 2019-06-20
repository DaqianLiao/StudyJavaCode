package com.ldq.study.date;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class NewDate {
   

    public static void testLocalDateTime() {

        // 获得当前的日期和时间
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("current date and time: " + currentTime);

        // 输出当前时间的本地值（本时区）
        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("local date: " + date1);

        Month month = currentTime.getMonth();
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();

        // 由当前时间对象获得各个字段，输出结果
        System.out.println("month: " + month + "day: " + day + "seconds: " + seconds);

        // 由当前时间附带月份和年再输出
        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
        System.out.println("date 2: " + date2);

        // 输出2016年圣诞节的日期
        LocalDate date3 = LocalDate.of(2016, Month.DECEMBER, 25);
        System.out.println("date 3: " + date3);

        // 输出新闻联播的开始时间
        LocalTime date4 = LocalTime.of(19, 00);
        System.out.println("date 4: " + date4);

        // 转化为字符串，再输出
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date 5: " + date5);
    }

    public static void testZonedDateTime() {

        // 将字符串代表的时区信息转化
        ZonedDateTime date1 = ZonedDateTime.parse("2016-04-20T19:22:15+01:30[Europe/Paris]");
        System.out.println("date1: " + date1);

        // 设定地区ID为亚洲的加尔各答（位于印度），并输出
        ZoneId id = ZoneId.of("Asia/Kolkata");
        System.out.println("ZoneId: " + id);

        // 获得系统默认的当前地区并输出
        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("CurrentZone: " + currentZone);
    }

    public static void testChromoUnits() {

        // 获得当前的日期并输出
        LocalDate today = LocalDate.now();
        System.out.println("Current date: " + today);

        // 在当前日期的基础上增加两周时间再输出
        LocalDate nextWeek = today.plus(2, ChronoUnit.WEEKS);
        System.out.println("two weeks after now: " + nextWeek);

        // 在当前日期的基础上增加6个月的时间再输出
        LocalDate nextMonth = today.plus(6, ChronoUnit.MONTHS);
        System.out.println("6 months after now: " + nextMonth);

        // 在当前日期的基础上增加5年的时间再输出
        LocalDate nextYear = today.plus(5, ChronoUnit.YEARS);
        System.out.println("5 years after now: " + nextYear);

        // 在当前日期的基础上增加20年的时间再输出（一个Decade为10年）
        LocalDate nextDecade = today.plus(2, ChronoUnit.DECADES);
        System.out.println("20 years after now: " + nextDecade);
    }


    /**
     * 该类用于处理日期相关的时间段
     */
    public static void showPeriod() {

        // 获得当前的日期
        LocalDate date1 = LocalDate.now();
        System.out.println("Current date: " + date1);

        // 在当前日期的基础上增加一个月时间
        LocalDate date2 = date1.plus(1, ChronoUnit.MONTHS);
        System.out.println("Next month: " + date2);

        // 用between方法计算两个日期直接的间隔（称之为Period）
        Period period = Period.between(date2, date1);
        System.out.println("Period: " + period);
    }

    /**
     * 该类用于处理时间相关的时间段
     */
    public static void showDuration() {

        LocalTime time1 = LocalTime.now();
        Duration fiveHours = Duration.ofHours(5);

        LocalTime time2 = time1.plus(fiveHours);

        // 对应的，用between方法显示两个时间直接的间隔（称之为Duration）
        Duration duration = Duration.between(time1, time2);
        System.out.println("Duration: " + duration);
    }

    public static void applyAdjusters() {

        // 获得当前的日期
        LocalDate now = LocalDate.now();
        System.out.println("current date: " + now);

        LocalDate firstDayOfMonth = now.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(firstDayOfMonth);

        LocalDate lastDayOfMonth = now.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDayOfMonth);

        // 计算下周一的日期并输出
        LocalDate nextMonday = now.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println("next monday on : " + nextMonday);

        // 获得下个月的第二个周期的日期并输出
        LocalDate firstInYear = LocalDate.of(now.getYear(), now.getMonth(), 1);
        LocalDate secondSunday = firstInYear.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)).with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println("second sunday of next month : " + secondSunday);
    }

    /**
     * 为了保持向后兼容的能力，原始的Date和Calendar对象添加了一个toInstant
     * 方法。该方法可以将其转换为新API下的对象
     *
     */
    public static void applyBackwardCompatability(){

        // 获得当前日期并输出
        Date currentDate = new Date();
        System.out.println("Current date: " + currentDate);

        // 获得当前日期的实例（以毫秒的形式）
        Instant now = currentDate.toInstant();
        ZoneId currentZone = ZoneId.systemDefault();

        // 用ofInstant方法获得实例
        LocalDateTime localDateTime = LocalDateTime.ofInstant(now, currentZone);
        System.out.println("Local date: " + localDateTime);

        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(now, currentZone);
        System.out.println("Zoned date: " + zonedDateTime);
    }

    public static void main(String[] args) {
        testChromoUnits();
        testLocalDateTime();
        testZonedDateTime();
        showDuration();
        showPeriod();
        applyAdjusters();
        applyBackwardCompatability();
    }
}
