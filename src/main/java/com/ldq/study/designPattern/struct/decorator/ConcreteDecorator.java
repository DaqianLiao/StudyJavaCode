package com.ldq.study.designPattern.struct.decorator;

/**
 * 具体装饰角色：实现抽象装饰角色的相关方法，同时给具体的构件对象添加附加责任
 */
public class ConcreteDecorator extends Decorator {

    public ConcreteDecorator(Component component) {
        super(component);
    }

    public void operation(){
        super.operation();
        addFunction();
    }

    private void addFunction() {
        System.out.println("为具体的构件角色增加额外的功能");
    }
}
