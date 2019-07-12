package com.ldq.study.designPattern.action.visitor;

/**
 * 定义一个访问者接口
 * 定义了想要访问的所有模块
 */
public interface CommuterPartVisitor {
    //第一种实现方式，给出具体实现类作为参数
    //需要定义不同的实现类方法
//    public void visit(Computer computer);
//    public void visit(Mouse mouse);
//    public void visit(Keyboard keyboard);
//    public void visit(Monitor monitor);

    //第二种实现方式，只需将接口作为类型
    public  void visit(ComputerPart part);
}
