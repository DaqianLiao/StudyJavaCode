package com.ldq.study.annotation.base;

import com.ldq.study.annotation.anno.Description;

/**
 * Created by diligent_leo on 2016/12/23
 */
@Description(desv = "asd", author = "diligent_leo", value = "I am class annotation")
public class Child {
    private String name;
    private int age;

    public Child(String name, int age) {
        this.name = name;
        this.age = age;
    }

    protected String name() {
        return name;
    }

    private void hello() {
        System.out.println("my name is " + name + ", my age is " + age);
    }

    public int age() {
        return 0;
    }
}
