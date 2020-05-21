package com.ldq.study.rpc.common;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;

    public Product(){}

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
