package com.ldq.study.serializable.kryo;

public class Msg {
    public String name;
    public int age;
    public short code;

    @Override
    public String toString() {
        return "Msg{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", code=" + code +
                '}';
    }
}
