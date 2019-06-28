package com.ldq.study.designPattern.create.abstructFactory;

public class HpFactory extends PCFactory {
    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }

    @Override
    public Keybo createKeybo() {
        return new HpKeybo();
    }
}
