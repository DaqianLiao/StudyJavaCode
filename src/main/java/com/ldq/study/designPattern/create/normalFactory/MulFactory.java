package com.ldq.study.designPattern.create.normalFactory;

import com.ldq.study.designPattern.create.simpleFactory.Mul;
import com.ldq.study.designPattern.create.simpleFactory.Operation;

public class MulFactory implements Factory {
    @Override
    public Operation createOperation() {
        return new Mul();
    }
}
