package com.ldq.study.designPattern.create.prototype.classPrototype;

public class Client {
    /**
     * 实现深拷贝的原型模式
     */
    private static void testDeepClone() {
        Attachment attachment = new Attachment("毕业证");
        WeekLog lily = new WeekLog("2019","lily", "offer", attachment);
        WeekLog lucy = lily.clone();
        System.out.println(lily);
        System.out.println(lucy);

        System.out.println("修改基本类型成员变量");
        lucy.setName("lucy");
        System.out.println(lily);
        System.out.println(lucy);

        System.out.println("修改引用类型成员变量");
        lucy.getAttachment().setName("学位证");
        System.out.println(lily);
        System.out.println(lucy);

    }
    public static void main(String[] args) {
        testDeepClone();
    }

}
