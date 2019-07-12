package com.ldq.study.designPattern.action.nullObject;

/**
 * 抽象类
 * 定义各种执行的操作
 */
public abstract class Customer {
    protected String name;
    public abstract boolean isNil();
    public abstract String getName();
}
