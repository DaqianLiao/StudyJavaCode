package com.ldq.study.designPattern.create.normalFactory;

import com.ldq.study.designPattern.create.simpleFactory.Div;
import com.ldq.study.designPattern.create.simpleFactory.Operation;

public class DivFactory implements Factory {
    @Override
    public Operation createOperation() {
        return new Div();
    }
}
