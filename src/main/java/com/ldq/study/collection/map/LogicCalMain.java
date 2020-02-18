package com.ldq.study.collection.map;

/**
 * 逻辑运算
 */
public class LogicCalMain {
    public static void main(String[] args) {
        int a = 3;
        int b = 4, c = 7, d = -4, e = -8;
        System.out.println("a = " + a + ", binary code = " + Integer.toBinaryString(a));
        System.out.println("b = " + b + ", binary code = " + Integer.toBinaryString(b));
        System.out.println("c = " + c + ", binary code = " + Integer.toBinaryString(c));
        System.out.println("d = " + d + ", binary code = " + Integer.toBinaryString(d));
        System.out.println("e = " + e + ", binary code = " + Integer.toBinaryString(e));
//        与运算符 &
//        两个操作数中位都为1，结果才为1，否则结果为0
        System.out.println("self and = " + (a & a));
        System.out.println("a and b = " + (a & b));
        System.out.println("a and c = " + (a & c));
//        或运算符 |
//        两个位只要有一个为1，那么结果就是1，否则就为0
        System.out.println("self or = " + (a | a));
        System.out.println("a or b  = " + (a | b));

//        非运算符 ~
//        如果位为0，结果是1，如果位为1，结果是0
        System.out.println("not a = " + (~a));
        System.out.println("not d = " + (~d));
        System.out.println("not c = " + (~c));

//        异或运算符 ^
//        两个操作数的位中，相同则结果为0，不同则结果为1
        System.out.println("self xor = " + (a ^ a));
        System.out.println("a xor b  = " + (a ^ b));
    }
}
