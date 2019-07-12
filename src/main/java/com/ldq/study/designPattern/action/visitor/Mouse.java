package com.ldq.study.designPattern.action.visitor;

/**
 * 具体的实现操作的不同对象
 */
public class Mouse implements ComputerPart {
    @Override
    public void accept(CommuterPartVisitor visitor) {
        visitor.visit(this);
    }
}
