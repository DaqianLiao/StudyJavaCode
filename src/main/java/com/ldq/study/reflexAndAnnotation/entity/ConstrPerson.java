package com.ldq.study.reflexAndAnnotation.entity;

import java.lang.reflect.Constructor;

public class ConstrPerson {

    private Gender gender;  // 性别
    private int age;        // 年龄
    private String name;    // 姓名

    private ConstrPerson() {
        this.name = "unknown";
        this.age = 0;
        this.gender = Gender.FEMALE;
        System.out.println("call--\"private ConstrPerson()\"");
    }

    protected ConstrPerson(String name) {
        this.name = name;
        this.age = 0;
        this.gender = Gender.FEMALE;
        System.out.println("call--\"protected ConstrPerson(String name)\"");
    }

    public ConstrPerson(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        System.out.println("call--\"public ConstrPerson(String name, int age, Gender gender)\"");
    }

    public ConstrPerson(String name, int age) {
        this.name = name;
        this.age = age;
        this.gender = Gender.FEMALE;
        //内部类在构造方法中
        class InnerA {
        }
        // 获取InnerA的Class对象
        Class cls = InnerA.class;

        // 获取“封闭该内部类(InnerA)”的构造方法
        Constructor cst = cls.getEnclosingConstructor();

        System.out.println("call--\"public ConstrPerson(String name, int age)\" \ncst=" + cst);
    }

    @Override
    public String toString() {
        return "(" + name + ", " + age + ", " + gender + ")";
    }
}
