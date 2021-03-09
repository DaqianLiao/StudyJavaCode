package com.ldq.study.util;

//运行时, jvm 把appmain的信息都放入方法区 
public class AppMain {
    //main 方法本身放入方法区。
    public static void main(String[] args) {
        //test1是引用，所以放到栈区里， Sample是自定义对象应该放到堆里面 
        Sample test1 = new Sample(" 测试1 ");
        test1.printName();
    }
}


