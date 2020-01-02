package com.ldq.study.designPattern.action.visitor;

/**
 * 访问者模式
 * 场景：对一个对象结构中的对象进行很多不同的且不相关的操作
 * 优点：复合单一职责原则，可扩展
 * 缺点：
 *      具体愿随对访问者公布细节，违反迪米特原则
 *      具体元素变更困难
 *      违反依赖倒置原则，依赖了具体类
 */
public class Client {
    private static void testVisit() {
        //被访问者对象
        Computer computer = new Computer();
        //创建访问者对象
        CommuterPartVisitor visitor = new CommuterDisplayVisitorImpl();
        computer.accept(visitor);
    }

    public static void main(String[] args) {
        testVisit();
    }


}
