package com.ldq.study.designPattern.struct.decorator;

public class Client {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        ConcreteDecorator concreteDecorator = new ConcreteDecorator(component);

        component.operation();
        System.out.println("++++++++++++++");
        concreteDecorator.operation();
    }
}
