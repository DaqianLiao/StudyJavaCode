package com.ldq.study.designPattern.create.builder;

/**
 * 当某个类特别多成员变量的时候，可以通过这种方式来构建类
 */
public class Person {

    private int id;
    private String name;
    private String province;
    private String city;
    private int age;

    public Person(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.province = builder.province;
        this.city = builder.city;
        this.age = builder.age;
    }

    public static class Builder {
        //        必须指定的参数
        private int id;
        private String name;
        //        可传可不传的参数
        private String province;
        private String city;
        private int age;

        public Builder(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder setProvince(String province) {
            this.province = province;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }


        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Person builder() {
            return new Person(this);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                '}';
    }
}
