package com.ldq.study.util.junit;

import org.junit.Test;

public class Junit {


    public static void main(String[] args) {
        testPrivateStaticJunit();
        testPublicStaticJunit();
        new Junit().testPublicJunit();
        new Junit().testPrivateJunit();
    }

    @Test
    /**
     * 测试方法必须使用注解 org.junit.Test 修饰。
     * 测试方法必须使用 public void 修饰，
     * 而且不能带有任何参数的方法才能运行
     */
    public void testPublicJunit() {
        System.out.println(" method is public");
    }

    @Test
    /**
     * 可以修饰，但是由于public 方法带有参数
     * 不能运行
     */
    public void testPublicJunitWithArgs(String... names) {
        System.out.println(" method is public with args = " + names);
    }

    @Test
    /**
     * 可以修饰，但是由于方法是private
     * 不能运行
     */
    private void testPrivateJunit() {
        System.out.println(" method is private");
    }

    @Test
    public static void testPublicStaticJunit() {
        System.out.println(" method is public static");
    }


    @Test
    private static void testPrivateStaticJunit() {
        System.out.println(" method is private static");
    }

}
