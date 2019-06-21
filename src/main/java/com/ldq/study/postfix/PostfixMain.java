package com.ldq.study.postfix;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class PostfixMain {

    public static void testIf() {
        //e.if
        boolean flag = true;
        if (flag) {
            System.out.println("input flag.if and enter. U can get this output");
        }

        //e.not
        System.out.println("input flag.not and enter. U can get this boolean value: " + !flag);

        //e.null
        String str = null;
        if (str == null) {
            System.out.println("input e.null and enter. get this output ");
        }

        //e.nn
        str = "";
        if (str != null) {
            System.out.println("input e.nn and enter. get this output ");
        }

    }

    public static void testFloop() {
        //10.fori
        System.out.println("input 10.fori, get this");
        for (int i = 0; i < 10; i++) {
            System.out.println("output  = " + i);
        }

        //10.forr
        System.out.println("input 10.forr, get this");
        for (int i = 10; i > 0; i--) {
            System.out.println("output  = " + i);
        }

        //flag.while
        boolean flag = true;
        while (flag) {
            System.out.println("input flag.while, get this");
            flag = false;
        }

        //list.iter
        System.out.println("input list.iter, get this");
        List<String> stringList = Arrays.asList("first", "second");
        for (String str : stringList) {
            System.out.println("iter str = " + str);
        }

    }

    public static void testSystem() {
        //exp.sout
        String str = "test%s";
        System.out.println("input str.sout, get this str = " + str);

        //exp.format
        System.out.println("input str.format.sout, get this result = " + String.format(str, "-i"));


    }

    public static void main(String[] args) {
        testIf();
        testFloop();
        testSystem();
    }
}
