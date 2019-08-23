package com.ldq.study.intEquals;

public class IntegerByteCodeCase {

    public static void main(String[] args) {
        int a = new Integer(3);
        Integer i1 = new Integer(150) ;
        Integer i2 = new Integer(150) ;
        System.out.println(i1 == i2);
    }

}
