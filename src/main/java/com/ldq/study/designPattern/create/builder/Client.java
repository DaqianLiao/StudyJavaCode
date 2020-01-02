package com.ldq.study.designPattern.create.builder;

public class Client {

    public static void testClassBuilder() {
        Person person = new Person.Builder(1, "jack")
                .setAge(25).setCity("shenzhen")
                .setProvince("guangdong").builder();

        System.out.println(person);
    }

    public static void testNormalBuilder() {

        MealA a = new MealA();
        KFCWaiter waiter = new KFCWaiter(a);
        Meal mealA = waiter.build();
        System.out.println(mealA.toString());

        MealB b = new MealB();
        waiter = new KFCWaiter(b);
        Meal mealB = waiter.build();
        System.out.println(mealB.toString());
    }

    public static void main(String[] args) {

        testClassBuilder();
        testNormalBuilder();
    }
}
