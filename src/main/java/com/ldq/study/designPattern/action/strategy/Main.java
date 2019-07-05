package com.ldq.study.designPattern.action.strategy;

import com.ldq.study.designPattern.action.strategy.impl.AddStrategyImpl;
import com.ldq.study.designPattern.action.strategy.impl.MultiplyStrategyImpl;
import com.ldq.study.designPattern.action.strategy.impl.SubstractStrategyImpl;

public class Main {
    public static void main(String[] args) {
        StrategyPattern pattern;
        pattern = new StrategyPattern(new AddStrategyImpl());
        System.out.println(pattern.execute(1, 2));

        pattern = new StrategyPattern(new SubstractStrategyImpl());
        System.out.println(pattern.execute(1, 2));
        pattern = new StrategyPattern(new MultiplyStrategyImpl());
        System.out.println(pattern.execute(1, 2));
    }
}
