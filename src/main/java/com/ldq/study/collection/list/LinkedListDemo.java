package com.ldq.study.collection.list;

import java.util.LinkedList;


public class LinkedListDemo {
    public static void main(String[] args) {
        /**
         * 内部结构是双链表
         */
        LinkedList<String> link = new LinkedList<>();
//        添加元素
        link.addFirst("abc1");
        System.out.println(link.getLast());
        link.addFirst("abc2");
        link.addFirst("abc3");
        System.out.println(link);
        /**
         * 利用了二分查找法的思想对元素进行遍历
         */
        System.out.println(link.get(2));
//        获取元素
        System.out.println(link.getFirst());
        System.out.println(link.getLast());
//        删除元素
        System.out.println(link.removeFirst());
        System.out.println(link.removeLast());
        while (!link.isEmpty()) { //判断集合是否为空
            System.out.println(link.pop()); //弹出集合中的栈顶元素
        }
        System.out.println(link);


    }
}
