package com.ldq.study.designPattern.create.builder;

/**
 * Director 指挥者
 * 构建一个使用Builder接口的对象，用于创建复杂的对象
 * 作用：
 * 1/隔离了客户与对象的生产过程
 * 2/负责控制产品对象的生产过程
 */
public class KFCWaiter {
    private MealBuilder builder;

    public KFCWaiter(MealBuilder builder) {
        this.builder = builder;
    }

    public Meal build() {
        builder.buildDrink();
        builder.buildFood();
        return builder.getMeal();
    }
}
