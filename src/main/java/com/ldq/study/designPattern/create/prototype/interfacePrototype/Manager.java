package com.ldq.study.designPattern.create.prototype.interfacePrototype;


import java.util.HashMap;
import java.util.Map;

/**
 * 使用者角色
 * 维护一个注册信息，通过指定的名字，找到对应的原型实例
 *
 */
public class Manager {
    private Map<String, Product> showCase = new HashMap<>();

    public void register(String name, Product product) {
        showCase.put(name, product);
    }

//    提供一个获取新实例的方法
    public Product create(String name) {
//        根据名字获取实例原型
        Product product = showCase.get(name);
//        委托复制实例的方法生成新实例
        return product.createClone();
    }

}
