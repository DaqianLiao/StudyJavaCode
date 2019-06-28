package com.ldq.study.designPattern.create.builder;

/**
 * Builder抽象建造者
 * 创建一个Product对象的哥哥不见指定抽象接口
 */
public abstract class MealBuilder {
    Meal meal = new Meal();

    public abstract void buildFood();

    public abstract void buildDrink();

    public Meal getMeal() {
        return meal;
    }

}
