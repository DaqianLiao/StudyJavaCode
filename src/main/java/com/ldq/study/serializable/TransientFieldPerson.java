package com.ldq.study.serializable;

import java.io.Serializable;

public class TransientFieldPerson implements Serializable {
    //通过判断类的serialVersionUID来验证的版本一致的
    private static final long serialVersionUID = -2095916884810199532L;
    private String name;
    private transient int age = 18;
    private transient String address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "TransientFieldPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
