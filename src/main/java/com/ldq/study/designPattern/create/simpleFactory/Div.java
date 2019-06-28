package com.ldq.study.designPattern.create.simpleFactory;

public class Div implements Operation {
    @Override
    public double getResult(double a, double b) throws Exception {
        if (b == 0) {
            throw new IllegalArgumentException("除数不能为0");
        }

        return a / b;

    }
}
