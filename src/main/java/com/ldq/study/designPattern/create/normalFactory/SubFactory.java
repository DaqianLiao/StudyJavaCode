package com.ldq.study.designPattern.create.normalFactory;

import com.ldq.study.designPattern.create.simpleFactory.Operation;
import com.ldq.study.designPattern.create.simpleFactory.Sub;

public class SubFactory implements Factory {
    @Override
    public Operation createOperation() {
        return new Sub();
    }
}
