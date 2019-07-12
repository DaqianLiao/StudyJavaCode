package com.ldq.study.designPattern.struct.facade;
/**
 * 具体实现类
 */
public class SquareShapeImpl implements Shape {
    @Override
    public void draw() {
        System.out.println("Square::draw");
    }
}
