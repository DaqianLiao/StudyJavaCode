package com.ldq.study.serializable;

import java.io.*;

public class Main {
    /**
     * 由于类Wanger没有实现序列化接口，
     * 因此会抛异常：java.io.NotSerializableException: com.ldq.study.serializable.Wanger
     */
    public static void testNoSerializable() {
        // 初始化对象
        Wanger wanger = new Wanger();
        wanger.setName("王二");
        wanger.setAge(18);
        System.out.println("init wangEr = " + wanger);

        String path = "data/serializable/wanger.txt";
        writeObject(wanger, path);
        readObject(path);
    }

    /**
     * 如果对象实现了Serializable接口，即可序列化该对象
     */
    public static void testSerializable() {
        // 初始化对象
        ZhangSan zhangSan = new ZhangSan();
        zhangSan.setName("张三");
        zhangSan.setAge(18);
        System.out.println("init ZhangSan = " + zhangSan);

        String path = "data/serializable/zhangSan.txt";
        writeObject(zhangSan, path);
        readObject(path);
    }

    /**
     * 静态字段属于类属性，不属于对象属性，
     * 对静态字段修改，反序列化对象，同时会变更静态字段的值
     * 有类加载器决定
     */
    public static void testStaticField() {
        StaticFieldPerson person = new StaticFieldPerson();
        person.setName("static");
        System.out.println("init StaticFieldPerson = " + person);

        String path = "data/serializable/StaticFieldPerson.txt";

        writeObject(person, path);

        //第一次读到的对象中，age是18
        System.out.println("第一次读取的反序列化的值：");
        readObject(path);
        //修改了原始Person数据
        //由于age是静态变量，属于类的状态，当对象反序列化的时候，
        // 由类加载器加载静态变量的值，所有反序列化对象会加载静态值
        person.setAge(10);
        //修改名字属性，对序列化后的对象无影响
        person.setName("modify");
        System.out.println("修改原始变量的静态成员和非静态成员值对比");
        System.out.println("modify person = " + person);
        readObject(path);
    }


    /**
     * transient 修饰的字段，反序列化后为类型的默认值
     */
    public static void testTransientField() {
        TransientFieldPerson person = new TransientFieldPerson();
        person.setName("transient");
        person.setAddress("china");
        System.out.println("init TransientFieldPerson = " + person);

        String path = "data/serializable/TransientFieldPerson.txt";

        writeObject(person, path);
        readObject(path);
    }

    /**
     * 实现Externalizable 接口
     * 需要重写接口方法
     */
    public static void testExternalizable() {
        ExternalizePerson person = new ExternalizePerson();
        person.setName("External");
        person.setAge(18);
        System.out.println("init ExternalizePerson = " + person);

        String path = "data/serializable/ExternalizePerson.txt";
        writeObject(person, path);
        readObject(path);
    }


    public static void writeObject(Object object, String path) {
        // 把对象写到文件中
        System.out.println("source hashcode = " + object.hashCode());
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(path))) {
            //从这一行进入，查看源码执行逻辑
            oos.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readObject(String path) {
        // 从文件中读出对象
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(new File(path)))) {
            Object read = ois.readObject();
            System.out.println("read from file! object = " + read);
            System.out.println("object hashcode = " + read.hashCode());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        try {
            testNoSerializable();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("=======================");
        testSerializable();

        System.out.println("=======================");
        testStaticField();

        System.out.println("=======================");
        testTransientField();

        System.out.println("=======================");
        testExternalizable();
    }
}
