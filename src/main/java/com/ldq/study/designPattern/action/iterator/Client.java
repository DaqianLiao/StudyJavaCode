package com.ldq.study.designPattern.action.iterator;

/**
 * 提供了一种新的遍历聚合对象的方法
 */
public class Client {
    public static void main(String[] args) {
        NameRepository names = new NameRepository();

        for (Iterator it = names.getIterator(); it.hasNext(); ) {
            String name = (String) it.next();
            System.out.println("name: " + name);
        }
    }

}
