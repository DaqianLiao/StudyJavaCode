package com.ldq.study.collection.set.skipList;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

public class ConcurrentSkipListSetDemo2 {

    public static void main(String[] args) {

        Set<String> set = new ConcurrentSkipListSet<String>();
        int size = 10;
        for (int i = 0; i < size; i++) {
            set.add("b" + i);
            set.add("a" + i);
            System.out.print("start print set : ");
            Util.printAll(set);
            System.out.println("=====================");
        }
    }
}
