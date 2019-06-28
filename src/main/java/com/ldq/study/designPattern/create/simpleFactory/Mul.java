package com.ldq.study.designPattern.create.simpleFactory;

public class Mul implements Operation {
    @Override
    public double getResult(double a, double b) {
        return a * b;
    }
}
