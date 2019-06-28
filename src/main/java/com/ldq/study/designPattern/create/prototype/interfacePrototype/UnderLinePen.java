package com.ldq.study.designPattern.create.prototype.interfacePrototype;

public class UnderLinePen implements Product {
    private char aChar;

    public UnderLinePen(char aChar) {
        this.aChar = aChar;
    }

    @Override
    public void use(String s) {
        int len = s.getBytes().length;

        System.out.println("");
        System.out.println(" \"" + s + " \"");
        for (int i = 0; i < len + 4; i++) {
            System.out.print(aChar);
        }
        System.out.println("");
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
