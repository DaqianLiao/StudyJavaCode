package com.ldq.study.designPattern.action.visitor;


/**
 * 定义一个具体，汇总访问者的所有访问请求
 * 具体的实现操作的不同对象
 */
public class Computer implements ComputerPart {

    ComputerPart[] parts;

    //构造方法中定义了整体中的所有成员
    public Computer() {
        this.parts = new ComputerPart[]{new Mouse(),new Monitor(),new Keyboard()};
    }

    @Override
    public void accept(CommuterPartVisitor visitor) {
        //对所有成员进行访问
        for (int i = 0; i < parts.length; i++) {
            parts[i].accept(visitor);
        }
        visitor.visit(this);
    }
}
