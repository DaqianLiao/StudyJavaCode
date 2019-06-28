package com.ldq.study.designPattern.create.normalFactory;

import com.ldq.study.designPattern.create.simpleFactory.Operation;

public interface Factory {
    public Operation createOperation();
}
