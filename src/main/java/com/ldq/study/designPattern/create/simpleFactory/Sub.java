package com.ldq.study.designPattern.create.simpleFactory;

/**
 * 减法类
 */
public class Sub implements Operation {
    @Override
    public double getResult(double a, double b) {
        return a-b;
    }
}
