package com.ldq.study.finalDemo;

public class Person {
    private String name;
    private String label;
    private int age;

    public Person(String name, String label, int age) {
        this.name = name;
        this.label = label;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", label='" + label + '\'' +
                ", age=" + age +
                '}';
    }
}
