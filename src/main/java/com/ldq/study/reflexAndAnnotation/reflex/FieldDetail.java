package com.ldq.study.reflexAndAnnotation.reflex;

import com.ldq.study.reflexAndAnnotation.entity.FieldPerson;
import com.ldq.study.reflexAndAnnotation.entity.Gender;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FieldDetail {

    /**
     * getDeclaredField() 的测试函数
     * 用于获取的是类自身声明的所有成员遍历，
     * 包含public、protected和private 成员变量。
     */
    @Test
    public void testGetDeclaredField() {
        try {
            // 获取Person类的Class
            Class<?> cls = FieldPerson.class;

            Field[] declaredFields = cls.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                System.out.println("declaredField info: " + declaredField.getName() + ": " +
                        Modifier.toString(declaredField.getModifiers()));
            }

            // 根据class，调用类的默认构造函数(不带参数)
            Object person = cls.newInstance();

            // 根据class，获取Filed
            Field fName = cls.getDeclaredField("name");
            Field fAge = cls.getDeclaredField("age");
            Field fGender = cls.getDeclaredField("gender");

            // 根据构造函数，创建相应的对象
            fName.set(person, "Hamier");
            try {
                // 因为"age"是private权限，所以要设置访问权限为true；否则，会抛出异常。
                fAge.set(person, 31);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //设置访问权限，就可以访问了
            fGender.setAccessible(true);
            fGender.set(person, Gender.FEMALE);

            System.out.printf("%-30s: person=%s\n",
                    "getDeclaredField()", person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * getField() 的测试函数
     * getField() 用于获取的是public的“成员”
     */
    @Test
    public void testGetField() {
        try {
            // 获取Person类的Class
            Class<?> cls = FieldPerson.class;

            Field[] fields = cls.getFields();
            for (Field field : fields) {
                System.out.println("field info: " + field.getName() + ": " +
                        Modifier.toString(field.getModifiers()));
            }
            // 根据class，调用类的默认构造函数(不带参数)
            Object person = cls.newInstance();

            // 根据class，获取Filed
            Field fName = cls.getField("name");
            Field fAge = cls.getDeclaredField("age");       // 抛出异常，因为Person中age是protected权限。
            Field fGender = cls.getDeclaredField("gender"); // 抛出异常，因为Person中gender是private权限。

            // 根据构造函数，创建相应的对象
            fName.set(person, "Grace");
            System.out.println(fName.get(person));
            //fAge.set(person, 26);
            //fGender.set(person, Gender.FEMALE);

            System.out.printf("%s: person=%s\n", "getField()", person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
