package com.ldq.study.clone.deep;


import com.ldq.study.clone.deep.Address;

public class Customer implements Cloneable {
    private String name;
    private Address address;

    public Customer(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }

    @Override
    public Customer clone() {
        Customer customer = null;
        try {
            customer = (Customer) super.clone();
            customer.address = address.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return customer;
    }
}
