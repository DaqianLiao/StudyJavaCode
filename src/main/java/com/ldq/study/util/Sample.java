package com.ldq.study.util;

//运行时, jvm 把 Sample 的信息都放入方法区 
public class Sample {
    private String name;

    //new Sample实例后， name 引用放入栈区里，  name 对象放入堆里 
    public Sample(String name) {
        this.name = name;
    }

    //print方法本身放入方法区里。
    public void printName() {
        System.out.println(name);
    }



}