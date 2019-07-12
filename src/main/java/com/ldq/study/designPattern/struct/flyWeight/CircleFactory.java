package com.ldq.study.designPattern.struct.flyWeight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元对象工厂类
 */
public class CircleFactory {
    //存储同一个类型的实现类
    private static Map<String, Shape> circles = new HashMap<>();

    /**
     * 针对产生大量相似的对象，将对象缓存起来，达到复用的目的
     * 复用的对象是同一个地址，当修改了对象属性值，同一个key对应的对象都改变
     * @param color
     * @return
     */
    public static Shape getCircle(String color) {
        CircleShapeImpl shape = (CircleShapeImpl) circles.get(color);
        if (shape == null) {
            shape = new CircleShapeImpl(color);
            circles.put(color, shape);
            System.out.println("Create Circle of color: " + color);
        }
        return shape;
    }
}
