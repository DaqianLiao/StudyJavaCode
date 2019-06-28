package com.ldq.study.designPattern.create.prototype.interfacePrototype;

/**
 * 具体原型类：
 * 实现了抽象原型类中申明的克隆方法，在克隆方法中返回一个自己的克隆对象
 *
 */
public class MessageBox implements Product {
    private char aChar;

    public MessageBox(char aChar) {
        this.aChar = aChar;
    }


    @Override
    public void use(String s) {
        int len = s.getBytes().length;
        for (int i = 0; i < len + 4; i++) {
            System.out.print(aChar);
        }
        System.out.println();
        System.out.println(aChar + " " + s + " " + aChar);
        for (int i = 0; i < len + 4; i++) {
            System.out.print(aChar);
        }
        System.out.println();
    }

    @Override
    public Product createClone() {
        Product p = null;
        try {
            p = (Product) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
