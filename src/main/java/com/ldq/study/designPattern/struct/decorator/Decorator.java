package com.ldq.study.designPattern.struct.decorator;

/**
 * 抽象装饰角色：包含具体构件角色的实例，通过子类扩展具体都见的功能
 */
public class Decorator implements Component {

    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}
