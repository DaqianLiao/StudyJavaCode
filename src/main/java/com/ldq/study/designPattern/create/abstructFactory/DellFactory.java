package com.ldq.study.designPattern.create.abstructFactory;

public class DellFactory extends PCFactory{
    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }

    @Override
    public Keybo createKeybo() {
        return new DellKeybo();
    }
}
