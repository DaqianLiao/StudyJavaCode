package com.ldq.study.designPattern.struct.filter;


public class Person {
    private String name;
    private int age;
    private String sex;
    private String marital;


    public Person(String name, int age, String sex, String marital) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.marital = marital;
    }

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMarital() {
        return marital;
    }

    public void setMarital(String marital) {
        this.marital = marital;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", marital='" + marital + '\'' +
                '}';
    }
}
