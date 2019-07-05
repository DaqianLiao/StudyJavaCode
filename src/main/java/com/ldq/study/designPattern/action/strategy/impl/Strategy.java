package com.ldq.study.designPattern.action.strategy.impl;

/**
 * 定义策略模式的抽象方法接口
 * 使用接口的方式，更加灵活
 * 当新增一个策略的时候，只需要新增一个接口的实现，
 * 客户端就可以直接使用新策略
 *
 */
public interface Strategy {
    int doOperation(int num1,int num2);
}
