package com.ldq.study.clone.slow;


/**
 * 浅克隆仅仅复制所有普通的成员变量的值，
 * 其他对象的引用依然指向原来的值
 */
public class Main {
    public static void testClone() {
        Address address = new Address("China", "guangdong", "shenzhen");
        Customer c1 = new Customer("Lily", address);
        Customer c2 = c1.clone();
        System.out.println(c1.toString());
        System.out.println(c2.toString());

//        修改普通成员变量的值，只改变自身
        c2.setName("jack");
        System.out.println(c2.toString());

//        修改引用对象值，两者都会变化，说明两者引用的是相同的地址
        c2.getAddress().setCity("guangzhou");
        System.out.println(c1.toString());
        System.out.println(c2.toString());
    }

    public static void main(String[] args) {
        testClone();
    }
}
