package com.ldq.study.exception;

import java.util.Random;

public class Ex {
    /**
     * 受查异常，必须对异常处理，否则编译不过去
     */
//    public static void testCheckException(){
//        Thread.sleep(100);
//    }
    public static void testSleep() {
        try {
            System.out.println("before exception");
            Thread.sleep(1000);
            throw new InterruptedException("user interrupt thread!");
            //下面的代码是不会执行的，而且编译器也编译不过去
//            System.out.println("after exception");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("this is catch part");
        }
    }

    /**
     * finally代码执行
     */
    public static void testFinally() {
        try {
            System.out.println("before exception");
            Thread.sleep(1000);
            throw new InterruptedException("user interrupt thread!");
            //下面的代码是不会执行的，而且编译器也编译不过去
//            System.out.println("after exception");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("this is catch part");
        } finally {
            System.out.println("this is finally part");
        }
    }

    /**
     * 不管什么地方return后，finally中的代码还是会执行
     *
     * @return
     */
    public static int testReturn() {
        try {
            System.out.println("before exception");
            Thread.sleep(1000);
            if (new Random().nextBoolean()) {
                throw new InterruptedException("user interrupt thread!");
            }
            //下面的代码是不会执行的，而且编译器也编译不过去
            System.out.println("this is no exception");
            return 0;
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("this is catch part");
            return 1;
        } finally {
            System.out.println("this is finally part");
        }
    }

    /**
     * finally中的return会覆盖其他部分的值
     *
     * @return
     */
    public static int testReturnFinally() {
        try {
            System.out.println("before exception");
            Thread.sleep(1000);
            if (new Random().nextBoolean()) {
                throw new InterruptedException("user interrupt thread!");
            }
            //下面的代码是不会执行的，而且编译器也编译不过去
            System.out.println("this is no exception");
            return 0;
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("this is catch part");
            return 1;
        } finally {
            System.out.println("this is finally part");
            return 2;
        }
    }

    public static void main(String[] args) {
        testSleep();
        System.out.println("=====void function finally中代码会被执行=====");
        testFinally();
        System.out.println("=====return function finally中代码也会执行=====");
        System.out.println("result = " + testReturn());
        System.out.println("=====finally中包含return====");
        for (int i = 0; i < 4; i++) {
            System.out.println("result = " + testReturnFinally());
            System.out.println("************************");
        }
    }
}
