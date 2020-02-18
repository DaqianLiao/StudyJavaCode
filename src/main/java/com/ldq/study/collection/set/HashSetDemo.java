package com.ldq.study.collection.set;

import java.util.HashSet;

public class HashSetDemo {

    public static void test() {

//        创建 Set集合
        HashSet<String> set = new HashSet<>();
//          添加元素
        set.add(new String("cba"));
        set.add("abc");
        set.add("bac");
        set.add("cba");
//         遍历
        for (String name : set) {
            System.out.println(name);
        }
    }

    public static void testObject() {
//        创建集合对象	该集合中存储 Student类型对象
        HashSet<Student> stuSet = new HashSet<>();
//        存储
        Student stu = new Student("于谦", 43);
        stuSet.add(stu);
        stuSet.add(new Student("郭德纲", 44));
        stuSet.add(new Student("于谦", 43));
        stuSet.add(new Student("郭麒麟", 23));
        stuSet.add(stu);
        for (Student s :
                stuSet) {
            
        }
        for (Student stu2 : stuSet) {
            System.out.println(stu2);
        }
    }


    public static void main(String[] args) {
        test();
        testObject();
    }
}
