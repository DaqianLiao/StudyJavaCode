package com.ldq.study.designPattern.create.normalFactory;

import com.ldq.study.designPattern.create.simpleFactory.Add;
import com.ldq.study.designPattern.create.simpleFactory.Operation;

public class AddFactory implements Factory {
    @Override
    public Operation createOperation() {
        return new Add();
    }
}
