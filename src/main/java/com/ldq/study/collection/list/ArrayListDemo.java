package com.ldq.study.collection.list;

import java.util.*;

public class ArrayListDemo {

    public static void testList() {

//        创建List集合对象
        List<String> list = new ArrayList<>();
//        往 尾部添加 指定元素
        list.add("图图");
        list.add("小美");
        list.add(null);
        list.add("不高兴");
        System.out.println(list);
//        add( int index, String s)往指定位置添加
        list.add(1, "没头脑");
        System.out.println(list);
//        String remove ( int index)删除指定位置元素 返回被删除元素
//        删除索引位置为2的元素
        System.out.println("删除索引位置为2的元素");
        System.out.println(list.remove(2));
        System.out.println(list);
//        String set ( int index, String s)
//        在指定位置 进行 元素替代（改）
//        修改指定位置元素
        list.set(0, "三毛");
        System.out.println(list);
//        String get ( int index)获取指定位置元素
//        跟size() 方法一起用 来 遍历的
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
//        还可以使用增强for
        for (String string : list) {
            System.out.println(string);
        }
    }


    public static void testIterator() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(i ^ 2 + 1);
        }

        long start = System.currentTimeMillis();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
        }

        long end = System.currentTimeMillis();
        System.out.println("iterator list spend: " + (end - start) + "ms");



    }

    public static void main(String[] args) {


        testIterator();
//        testList();
    }
}
