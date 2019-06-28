package com.ldq.study.designPattern.create.prototype.interfacePrototype;

/**
 * 抽象原型类： 申明克隆方法的接口，是所有具体原型累的公共父类
 * 可以是接口，也可以是抽象类，甚至是具体的实现类
 */
public interface Product extends Cloneable {
    public abstract void use(String s);
    public abstract Product createClone();
}
