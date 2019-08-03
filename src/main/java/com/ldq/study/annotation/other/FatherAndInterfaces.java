package com.ldq.study.annotation.other;

import com.ldq.study.annotation.entity.ConstrPerson;
import com.ldq.study.annotation.entity.InterfacesPerson;
import org.junit.Test;

import java.lang.reflect.Type;

public class FatherAndInterfaces {

    @Test
    public void testInterfaces(){
        Class<InterfacesPerson> interfacesPersonClass = InterfacesPerson.class;
        Class<?>[] interfaces = interfacesPersonClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("anInterface.getName() = " + anInterface.getName());
        }

        Type[] genericInterfaces = interfacesPersonClass.getGenericInterfaces();
        for (Type genericInterface : genericInterfaces) {
            System.out.println("genericInterface.getTypeName() = " + genericInterface.getTypeName());
        }
    }

    @Test
    /**
     * 由于Java单继承特性，因此不会有获取父类集合的方法
     * 只能获取单个父类
     * 1/如果没有指定父类，则获取的是默认的父类 object类
     * 2/如果显式指定了父类，则获取的是指定的父类
     */
    public void getFather(){
        Class<InterfacesPerson> interfacesPersonClass = InterfacesPerson.class;
        Type genericSuperclass = interfacesPersonClass.getGenericSuperclass();
        System.out.println("genericSuperclass.getTypeName() = " + genericSuperclass.getTypeName());

        Class<ConstrPerson> constrPersonClass = ConstrPerson.class;
        Type genericSuperclass1 = constrPersonClass.getGenericSuperclass();
        System.out.println("genericSuperclass1.getTypeName() = " + genericSuperclass1.getTypeName());
    }

}
