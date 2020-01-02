package com.ldq.study.designPattern.principle.openclose;

public class ComputerCourse implements ICourse {
    private String name;
    private int id;
    private Double price;

    public ComputerCourse() {

    }

    public ComputerCourse(int id, String name, Double price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "ComputerCourse{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", price=" + price +
                '}';
    }
}
