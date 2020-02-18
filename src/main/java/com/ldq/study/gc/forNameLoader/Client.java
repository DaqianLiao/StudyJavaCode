package com.ldq.study.gc.forNameLoader;

import org.junit.Test;

public class Client {
    @Test
    public void loader(){
        try {
            ClassLoader.getSystemClassLoader().loadClass("com.ldq.study.gc.forNameLoader.WaitClass");
            System.out.println("#########-------------结束符------------##########");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void forName(){
        try {
            Class.forName("com.ldq.study.gc.forNameLoader.WaitClass");
            System.out.println("#########-------------结束符------------##########");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void client(){
        System.out.println("Start forName");
        forName();
        System.out.println("Start loader");
        loader();
    }
}
