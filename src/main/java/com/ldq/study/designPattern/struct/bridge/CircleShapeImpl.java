package com.ldq.study.designPattern.struct.bridge;

/**
 * 桥接抽象类的具体实现类
 * 个性化自己的抽象方法
 */
public class CircleShapeImpl extends Shape {
    private int radius;
    private int x;
    private int y;

    public CircleShapeImpl(BasedDraw basedDraw, int radius, int x, int y) {
        super(basedDraw);
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        basedDraw.draw(radius, x, y);
    }
}
