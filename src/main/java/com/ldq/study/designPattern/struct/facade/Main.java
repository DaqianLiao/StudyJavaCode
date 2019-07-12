package com.ldq.study.designPattern.struct.facade;

/**
 * 外观模式
 * 优点：
 *      减少了系统的相互依赖，客户端职能调用外观类方法
 *      子系统是隐藏的
 * 缺点：不符合开闭原则
 *
 *
 */
public class Main {
    public static void testFacade() {
        ShapeMaker shapeMaker = new ShapeMaker();
        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }

    public static void main(String[] args) {
        testFacade();
    }
}
