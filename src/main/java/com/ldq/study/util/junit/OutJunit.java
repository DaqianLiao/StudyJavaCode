package com.ldq.study.util.junit;

public class OutJunit {

    /**
     * 只能调用类的共有方法
     * @param args
     */
    public static void main(String[] args) {
//        共有静态方法调用形式
        Junit.testPublicStaticJunit();
//        共有非静态方法调用形式
        new Junit().testPublicJunit();
        //由于是私有方法，因此不能在外部调用
//        new Junit().testPrivateJunit();
    }
}
