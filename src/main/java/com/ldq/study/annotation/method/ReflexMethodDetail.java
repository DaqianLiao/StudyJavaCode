package com.ldq.study.annotation.method;

import com.ldq.study.annotation.base.Person;
import org.junit.Test;

import java.lang.reflect.Method;

public class ReflexMethodDetail {
    public static void main(String[] args) throws ClassNotFoundException {
        String name = "com.ldq.study.annotation.base.Person";
        Class<?> aClass = Class.forName(name);
        //获取类的全限定名
        System.out.println("aClass.getName() = " + aClass.getName());
        //只获取类名
        System.out.println("aClass.getSimpleName() = " + aClass.getSimpleName());
        System.out.println("aClass.getCanonicalName() = " + aClass.getCanonicalName());
        System.out.println("aClass.getTypeName() = " + aClass.getTypeName());


    }

    @Test
    public void getMethods(){
        Class aClass = Person.class;
        /**
         * 获取类的所有共有方法
         * 1/该类的自定义的所有public修饰的方法
         * 2/继承自Object类的共有方法
         * 3/如果有其他的父类或者接口的共有方法
         */
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            System.out.println("method.getName() = " + method.getName());
        }

        System.out.println("==============");
        /**
         * 获取该类所有的方法
         */
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println("method.getName() = " + method.getName());
        }


        Method enclosingMethod = aClass.getEnclosingMethod();
        System.out.println(enclosingMethod.getName());
    }
}
