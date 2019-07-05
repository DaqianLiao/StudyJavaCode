package com.ldq.study.designPattern.action.strategy.impl;

/**
 * 定义具体的策略
 */
public class AddStrategyImpl implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
