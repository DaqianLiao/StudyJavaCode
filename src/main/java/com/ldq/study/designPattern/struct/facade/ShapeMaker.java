package com.ldq.study.designPattern.struct.facade;

/**
 * 定义外观模式的具体实现类
 * 所有客户端的操作，只有这个类提供具体的实现
 * 内部封装了具体的子系统的实例对象
 */
public class ShapeMaker {
    private Shape rectangle;
    private Shape circle;
    private Shape square;


    public ShapeMaker() {
        rectangle = new RectangleShapeImpl();
        circle = new CircleShapeImpl();
        square = new SquareShapeImpl();
    }

    public void drawCircle() {
        circle.draw();
    }

    public void drawSquare() {
        square.draw();
    }

    public void drawRectangle() {
        rectangle.draw();
    }
}

