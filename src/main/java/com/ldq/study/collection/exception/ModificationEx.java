package com.ldq.study.collection.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ModificationEx {


    public static void fastFail() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        list.forEach(x -> {
            /**
             * 由于fast-fail机制，会抛出并发修改异常
             */
            if (x == 4) {
                list.add(44);
            }
            System.out.println("x = " + x);
        });
    }

    public static void fastSafe() {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<Integer>();
        for (int i = 0; i < 8; i++) {
            list.add(i);
        }

        list.forEach(x -> {
            /**
             *  在遍历的时候，添加元素，不会报错
             *  但是添加的元素，是不会在当次遍历时读取
             */
            if (x == 4) {
                list.add(10);
            }
            System.out.println("x = " + x);
        });

        System.out.println("-------iterator fast safe list after add 10---------");

        list.forEach(x -> {
            System.out.println("x = " + x);
        });
    }

    public static void main(String[] args) {
        fastSafe();
        System.out.println("========");
        fastFail();
    }
}
