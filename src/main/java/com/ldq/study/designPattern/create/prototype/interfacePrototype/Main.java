package com.ldq.study.designPattern.create.prototype.interfacePrototype;

public class Main {
    /**
     * 实现了浅克隆方式
     */
    public static void test() {
        Manager manager = new Manager();
        MessageBox mbox = new MessageBox('*');
        MessageBox sbox = new MessageBox('=');
        manager.register("jack", mbox);
        manager.register("lily", sbox);
        Product p1 = manager.create("jack");
        p1.use("I'm jack");
        Product p2 = manager.create("lily");
        p2.use("I'm Lily");

        UnderLinePen under = new UnderLinePen('~');
        manager.register("King", under);
        Product p3 = manager.create("King");
        p3.use("I'm King");
        Product p4 = manager.create("King");
        p4.use("I'm other King");
    }

    public static void main(String[] args) {
        test();
    }
}
