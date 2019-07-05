package com.ldq.study.designPattern.action.strategy;

import com.ldq.study.designPattern.action.strategy.impl.Strategy;

/**
 * 构件了一个通用的策略执行类，通过传入不同的策略，执行不同的方法
 */
public class StrategyPattern {
    Strategy strategy;

    public StrategyPattern(Strategy strategy) {
        this.strategy = strategy;
    }

    public int execute(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}
