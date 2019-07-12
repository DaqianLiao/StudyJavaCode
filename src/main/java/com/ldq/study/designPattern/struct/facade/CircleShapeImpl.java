package com.ldq.study.designPattern.struct.facade;

/**
 * 具体实现类，不同的子系统
 */
public class CircleShapeImpl implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle::draw");
    }
}
