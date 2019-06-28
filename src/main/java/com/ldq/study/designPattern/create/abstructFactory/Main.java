package com.ldq.study.designPattern.create.abstructFactory;


public class Main {

    public static void normal() {
        PCFactory dellFactory = FactoryProducer.createFactory("dell");
        PCFactory hpFactory = FactoryProducer.createFactory("hp");
        dellFactory.createKeybo().sayHi();
        dellFactory.createMouse().sayHi();
        hpFactory.createMouse().sayHi();
        hpFactory.createKeybo().sayHi();
        try {
            FactoryProducer.createFactory(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void reflex() throws Exception {
        PCFactory dellFactory = FactoryProducer
                .createFactoryByFeflex("com.ldq.study.designPattern.create.abstructFactory.DellFactory");
        PCFactory hpFactory = FactoryProducer
                .createFactoryByFeflex("com.ldq.study.designPattern.create.abstructFactory.HpFactory");
        dellFactory.createKeybo().sayHi();
        dellFactory.createMouse().sayHi();
        hpFactory.createMouse().sayHi();
        hpFactory.createKeybo().sayHi();
        try {
            FactoryProducer.createFactory(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        normal();
        reflex();
    }
}
