package com.ldq.study.clone.slow;


import org.junit.Test;

/**
 * 浅克隆仅仅复制所有普通的成员变量的值，
 * 其他对象的引用依然指向原来的值
 */
public class Main {

    @Test
    public void testClone() {
        Address address = new Address("China", "guangdong", "shenzhen");
        Customer c1 = new Customer("Lily", address);
        Customer c2 = c1.clone();
        System.out.println(c1.toString());
        System.out.println(c2.toString());

//        修改普通成员变量的值，只改变自身
        c2.setName("jack");
        System.out.println(c2.toString());

//        修改引用对象值，两者都会变化，说明两者引用的是相同的地址
        c2.getAddress().setCity("guangzhou");
        System.out.println(c1.toString());
        System.out.println(c2.toString());
    }

    class Customer implements Cloneable {
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
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return customer;
        }
    }

    class Address {
        private String country;
        private String province;
        private String city;

        public Address(String country, String province, String city) {
            this.country = country;
            this.province = province;
            this.city = city;
        }

        public String getCountry() {
            return country;
        }

        public String getProvince() {
            return province;
        }

        public String getCity() {
            return city;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public void setCity(String city) {
            this.city = city;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "country='" + country + '\'' +
                    ", province='" + province + '\'' +
                    ", city='" + city + '\'' +
                    '}';
        }
    }

}
