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

    public static void writeObject(Object object, String path) {
        // 把对象写到文件中
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
    }
}
