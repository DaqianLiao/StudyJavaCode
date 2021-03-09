package com.ldq.study.collection.set.skipList;

import java.util.Iterator;
import java.util.Set;

public class Util {
    static void printAll(Set<String> set) {
        String value;
        Iterator iter = set.iterator();
        while(iter.hasNext()) {
            value = (String)iter.next();
            System.out.print(value+", ");
        }
        System.out.println();
    }
}
