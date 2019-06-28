package com.ldq.study.clone.deep;

import java.io.*;

public class CustomerSerial implements Serializable {
    private String name;
    private AddressSerial address;

    public CustomerSerial(String name, AddressSerial address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public AddressSerial getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(AddressSerial address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }


    public CustomerSerial deepclone() throws Exception{
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(this);

        ByteArrayInputStream bis = new ByteArrayInputStream(out.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (CustomerSerial) ois.readObject();


    }
}
