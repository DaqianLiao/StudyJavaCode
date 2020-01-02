package com.ldq.study.designPattern.principle.openclose;

/**
 * 开闭原则：对修改关闭，对扩展开放
 * 重点：尽量的通过继承父类的方式扩展子类的方法，避免修改现有类的逻辑
 */
public class MainOpenClose {

    public static void main(String[] args) {
        /**
         * 第一版需求，定义一个类，描述课程的基本属性
         */
        ComputerCourse computerCourse = new ComputerCourse(12,"Java从入门到精通",300d);
        System.out.println("computerCourse = " + computerCourse);

        /**
         * 第二版需求，现在做活动，指定课程打八折
         * 错误实现方式，对原始类进行大量的修改
         */
        ComputerCourseError computerCourseError = new ComputerCourseError(12,"Java从入门到精通",300d);
        System.out.println("computerCourseError = " + computerCourseError);

        /**
         * 正确的实现方式
         * 使用新的类，通过集成父类的方式，进行扩展
         */
        DiscountComputerCourse discountComputerCourse = new DiscountComputerCourse(12, "Java从入门到精通", 300d);
        System.out.println("discountComputerCourse = " + discountComputerCourse);
    }
}
