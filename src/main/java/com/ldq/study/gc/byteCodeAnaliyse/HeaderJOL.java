package com.ldq.study.gc.byteCodeAnaliyse;

import org.openjdk.jol.info.ClassLayout;

public class HeaderJOL {
    static void print(String message) {
        System.out.println(message);
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        Object obj =  new Object();
//        obj=4;
        //查看对象内部信息
        print(ClassLayout.parseInstance(obj).toPrintable());
        synchronized (obj){
            print(ClassLayout.parseInstance(obj).toPrintable());
        }

//        Object i = 4l;
//        print(ClassLayout.parseInstance(i).toPrintable());
//
//        System.gc();
//        print(ClassLayout.parseInstance(obj).toPrintable());
    }
}
