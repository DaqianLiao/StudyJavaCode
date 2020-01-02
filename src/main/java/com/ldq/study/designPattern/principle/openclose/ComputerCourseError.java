package com.ldq.study.designPattern.principle.openclose;

public class ComputerCourseError implements ICourseError {
    private String name;
    private int id;
    private Double price;

    private Double discountPrice;

    public ComputerCourseError() {

    }

    public ComputerCourseError(int id, String name, Double price) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.discountPrice = this.price * 0.8;
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
    public Double getDiscountPrice() {
        return this.discountPrice;
    }


    @Override
    public String toString() {
        return "ComputerCourseError{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", price=" + price +
                ", discountPrice=" + discountPrice +
                '}';
    }
}
