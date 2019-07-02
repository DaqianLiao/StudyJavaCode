package com.ldq.study.designPattern.struct.decorator;

/**
 * 具体构件角色：实现抽象构件角色，通过装饰角色为其添加一些职责
 */
public class ConcreteComponent implements Component {

    public ConcreteComponent() {
        System.out.println("具体的构件角色");
    }

    @Override
    public void operation() {
        System.out.println("调用具体构件角色的operation方法");
    }
}
