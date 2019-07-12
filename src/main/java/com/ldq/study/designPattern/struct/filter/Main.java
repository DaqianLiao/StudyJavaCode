package com.ldq.study.designPattern.struct.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * 过滤器模式
 * 根据自己定义的规则，进行过滤
 */
public class Main {

    private static void testFilter() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("lily", 20, "girl", "single"));
        personList.add(new Person("lucy", 21, "girl", "single"));
        personList.add(new Person("emily", 19, "girl", "single"));
        personList.add(new Person("jack", 30, "man", "married"));
        personList.add(new Person("leo", 28, "man", "single"));

        System.out.println("过滤单身");
        SingleFilterConditionImpl single = new SingleFilterConditionImpl();
        single.filter(personList).forEach(System.out::println);

        System.out.println("过滤男士");
        ManFilterConditionImpl man = new ManFilterConditionImpl();
        man.filter(personList).forEach(System.out::println);

        System.out.println("过滤女孩");
        GirlFilterConditionImpl girl = new GirlFilterConditionImpl();
        girl.filter(personList).forEach(System.out::println);
    }

    public static void main(String[] args) {
        testFilter();
    }


}
