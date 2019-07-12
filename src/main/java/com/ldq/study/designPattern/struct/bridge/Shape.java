package com.ldq.study.designPattern.struct.bridge;

/**
 * 定义桥接抽象类
 * 接受一个具体桥接接口实现类
 * 调用桥接接口方法
 */
public abstract class Shape {
    protected BasedDraw basedDraw;

    public Shape(BasedDraw basedDraw) {
        this.basedDraw = basedDraw;
    }

    public abstract void draw();
}
