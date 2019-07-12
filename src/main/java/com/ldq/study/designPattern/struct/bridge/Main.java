package com.ldq.study.designPattern.struct.bridge;

/**
 * 桥接模式：
 * 解耦抽象化和实现化，是的两者可以独立的变化
 * 可以单独的修改抽象方法，和接口中的方法
 * 实际上就是桥接了抽象类和接口
 * 对客户端透明，提高了扩展性
 */
public class Main {

    private static void testBridge() {
        Shape c1 = new CircleShapeImpl(new RedBasedDrawImpl(),10,100,100);
        Shape c2 = new CircleShapeImpl(new GreenBasedDrawImpl(),10,100,100);
        c1.draw();
        c2.draw();
    }

    public static void main(String[] args) {
        testBridge();
    }

}
