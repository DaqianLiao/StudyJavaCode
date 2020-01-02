package com.ldq.study.designPattern.struct.flyWeight;

import java.util.Random;

/**
 * 享元模式：
 * 通过共享技术支持大量细粒度的对象，解决了创建大量对象可能导致内存溢出
 * 对象可以根据特定的属性区分：：
 */
public class Client {

    private static void testFlyWeight() {
        String[] colors = {"green","red","blue","yellow","black","white","gray"};

        Random random = new Random();
        int radius = 100;
        for (int i = 0; i < 20; i++) {
            String color = colors[random.nextInt(colors.length)];
            int x = random.nextInt(20);
            int y = random.nextInt(20);
            CircleShapeImpl circleShape = (CircleShapeImpl) CircleFactory.getCircle(color);
            circleShape.setX(x);
            circleShape.setY(y);
            circleShape.draw();
        }
    }

    public static void main(String[] args) {
     testFlyWeight();
    }


}
