package com.ldq.study.designPattern.struct.bridge;

/**
 * 实现具体桥接类
 */
public class RedBasedDrawImpl implements BasedDraw {

    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius = " + radius +
                ", x = " + x + ", y = " + y);
    }
}
