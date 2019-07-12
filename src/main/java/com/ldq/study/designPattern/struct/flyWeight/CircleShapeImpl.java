package com.ldq.study.designPattern.struct.flyWeight;

/**
 * 具体的享元实现类，实现了具体的方法
 */
public class CircleShapeImpl implements Shape {
    private String color;
    private int radius;
    private int x;
    private int y;

    public CircleShapeImpl(String color) {
        this.color = color;
    }

    public CircleShapeImpl(String color, int radius, int x, int y) {
        this.color = color;
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void draw() {
        System.out.println("Draw Circle {" +
                "color='" + color + '\'' +
                ", radius=" + radius +
                ", x=" + x +
                ", y=" + y +
                '}');
    }

}
