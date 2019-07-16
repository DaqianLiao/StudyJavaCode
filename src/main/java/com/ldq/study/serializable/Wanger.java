package com.ldq.study.serializable;

public class Wanger {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Wanger{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
