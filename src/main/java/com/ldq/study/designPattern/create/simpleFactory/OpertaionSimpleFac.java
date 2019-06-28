package com.ldq.study.designPattern.create.simpleFactory;

/**
 * 简单工厂模式
 * 工厂根据传入的label返回具体实例，每次创建的实例都不相同
 * 实例都实现了同一个接口中的方法
 * 优点：用户不需要自己创建实例，将具有相同类型方法的实例归类到工厂中，实现简单的聚类创建
 * 缺点：每次增加或者减少工厂的实例，就需要修改SimpleFactory类，违反了开闭原则
 * 所有的实例都耦合在了一个工厂中
 */
public class OpertaionSimpleFac {
    public static Operation createOperation(String name) {
        Operation operation;
        switch (name) {
            case "+":
                operation = new Add();
                break;
            case "-":
                operation = new Sub();
                break;
            case "*":
                operation = new Mul();
                break;
            case "/":
                operation = new Div();
                break;
            default:
                throw new IllegalArgumentException("");
        }

        return operation;
    }
}
