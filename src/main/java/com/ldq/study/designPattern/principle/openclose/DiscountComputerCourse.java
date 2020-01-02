package com.ldq.study.designPattern.principle.openclose;

public class DiscountComputerCourse extends ComputerCourse {

    private Double discountPrice;

    public DiscountComputerCourse() {
    }

    public DiscountComputerCourse(int id, String name, Double price) {
        super(id, name, price);
        discountPrice = price * 0.8;
    }

    @Override
    public String toString() {
        return "DiscountComputerCourse{" +
                "name='" + getName() + '\'' +
                ", id=" + getId() +
                ", price=" + getPrice() +
                "discountPrice=" + discountPrice +
                '}';
    }
}
