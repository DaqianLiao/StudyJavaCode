package com.ldq.study.reflexAndAnnotation.entity;

public class FieldPerson {
    // private。性别
    private Gender gender;
    private String idCard;
    // protected。 年龄
    protected int age;
    protected int weight;
    // public。 姓名
    public String name;
    public String address;


    @Override
    public String toString() {
        return "FieldPerson{" +
                "gender=" + gender +
                ", idCard='" + idCard + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
