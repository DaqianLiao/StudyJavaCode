package com.ldq.study.gc.classLoader.loadMustInit;

import com.ldq.study.gc.classLoader.entity.SubClass;
import com.ldq.study.gc.classLoader.entity.SuperClass;

public class MustInitMain {

    public static void main(String[] args) {
//        newSuperClassLoad();
        newSubClassLoad();
    }

    /**
     * new Class case
     * 这种方式创建对象一定会触发初始化
     * 初始化一个没有父类的（或者本身就是父类，被子类继承的类）类，直接初始化即可
     */
    public static void newSuperClassLoad() {
        new SuperClass();
    }

    /**
     * new Class case
     * 这种方式创建对象一定会触发初始化
     * 初始化一个子类，必须保证父类也被初始化
     * 顺序：先初始化父类，在初始化子类
     */
    public static void newSubClassLoad() {
        new SubClass();
    }


}
