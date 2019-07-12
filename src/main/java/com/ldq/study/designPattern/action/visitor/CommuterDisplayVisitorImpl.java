package com.ldq.study.designPattern.action.visitor;

/**
 * 实现了具体的实体访问者类
 */
public class CommuterDisplayVisitorImpl implements CommuterPartVisitor {

    //第一种方式重写的方法
    @Override
    public void visit(ComputerPart part) {
        System.out.println("Display " + part.getClass().getName());
    }

    //第二种方法必须重写的方法
//    @Override
//    public void visit(Computer computer) {
//        System.out.println("Display computer");
//    }
//
//    @Override
//    public void visit(Mouse mouse) {
//        System.out.println("Display mouse");
//    }
//
//    @Override
//    public void visit(Keyboard keyboard) {
//        System.out.println("Display keyboard");
//    }
//
//    @Override
//    public void visit(Monitor monitor) {
//        System.out.println("Display monitor");
//    }


}
