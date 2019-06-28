package com.ldq.study.clone.deep;


/**
 * 深克隆不仅复制所有普通的成员变量的值，
 * 其他引用对象也会被复制
 * 修改点：
 * 1/需要将引用类型实现cloneable接口
 * 2/需要重写引用类型clone方法，并申明为public类型
 */
public class Main {
    public static void testClone() {
        Address address = new Address("China", "guangdong", "shenzhen");
        Customer c1 = new Customer("Lily", address);
        Customer c2 = c1.clone();
        System.out.println(c1.toString());
        System.out.println(c2.toString());

//        修改普通成员变量的值，只改变自身
        System.out.println("====================");
        c2.setName("jack");
        System.out.println(c2.toString());

//        修改引用对象值，只改变自身，说明深克隆
        System.out.println("====================");
        c2.getAddress().setCity("guangzhou");
        System.out.println(c1.toString());
        System.out.println(c2.toString());
    }

    public static void testSerialize() throws Exception {
        AddressSerial address = new AddressSerial("China", "guangdong", "shenzhen");
        CustomerSerial c1 = new CustomerSerial("Lily", address);
        CustomerSerial c2 = c1.deepclone();
        System.out.println(c1.toString());
        System.out.println(c2.toString());

//        修改普通成员变量的值，只改变自身
        System.out.println("====================");
        c2.setName("jack");
        System.out.println(c2.toString());

//        修改引用对象值，只改变自身，说明深克隆
        System.out.println("====================");
        c2.getAddress().setCity("guangzhou");
        System.out.println(c1.toString());
        System.out.println(c2.toString());
    }

    public static void main(String[] args) throws Exception {

        testClone();
        System.out.println("deep clone by serializable");
        testSerialize();
    }
}
