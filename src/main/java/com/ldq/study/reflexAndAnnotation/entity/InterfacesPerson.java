package com.ldq.study.reflexAndAnnotation.entity;

import java.io.Serializable;

/**
 * 实现了多个接口
 * 继承了 person 类
 */
public class InterfacesPerson extends Person implements Serializable, Runnable  {
    @Override
    public void run() {

    }
}
