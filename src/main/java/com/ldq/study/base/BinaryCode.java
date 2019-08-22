package com.ldq.study.base;

import org.junit.Test;

import static java.lang.Math.*;

/**
 * https://yq.aliyun.com/articles/529032?spm=a2c4e.11155472.0.0.54887282jdDIeJ
 *
 */
public class BinaryCode {

    /**
     * 位移运算：
     * <<：左移
     * >>：右移
     * >>>：无符号右移
     * 位运算是基于二进制bit来的
     * 需要将十进制转换为二进制之后再进行运算
     */
    @Test
    public void base() {
        System.out.println(2 << 1); // 4
        System.out.println(2 >> 1); // 1
        System.out.println(2 >>> 1); // 1
        System.out.println(-2 << 1); // -4
        System.out.println(-2 >> 1); // -1
        //由于是向右移动，符号为体都会向右移动
        System.out.println(-2 >>> 1); // 2147483647
    }

    @Test
    /**
     * 利用二进制中的第一位来表示符号位，0表示正数，1表示负数
     * 一个数字用二进制原码表示的话，取值范围是-111 1111 ~ +111 1111，换成十进制就是-127 ~ 127
     */
    public void sourceCode() {
        int num = 2;
        System.out.println(num + "原码： " + Integer.toBinaryString(num));
        System.out.println(num + "反码： " + Integer.toBinaryString(num));
       System.out.println(num + "补码： " + Integer.toBinaryString(num));

        int i = -3;
        System.out.println(abs(i) + "原码： " + Integer.toBinaryString(abs(i)));
        System.out.println(i + "反码： " + Integer.toBinaryString(~abs(i)));
        System.out.println(i + "补码： " + Integer.toBinaryString(~abs(i) + 1));


    }

    @Test
    /**
     * 正数的反码，补码和原码一样，
     * 负数的反码就是在原码的基础上符号位保持不变，其他位取反
     */
    public void code() {

        int num = -3;
        System.out.println("5 - 3 = " + (5 - 3));
        System.out.println("5 + (-3） = " + (5 +(-3)));
        System.out.println(5 + "补码： " + Integer.toBinaryString(5));
        System.out.println(num + "补码： " + Integer.toBinaryString(~abs(num) + 1));

        System.out.println(2 + "补码： " + Integer.toBinaryString(2));

    }
}
