package com.ldq.study.designPattern.create.builder;

/**
 * ContreteBuilder具体建造者
 * 实现抽象接口，构建和装配各个部件
 * 第二种实现方式
 */
public class MealB extends MealBuilder {
    @Override
    public void buildFood() {
        meal.setFood("卤肉饭");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("橙汁");
    }
}
