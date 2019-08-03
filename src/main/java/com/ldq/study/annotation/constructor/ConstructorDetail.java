package com.ldq.study.annotation.constructor;

import com.ldq.study.annotation.entity.ConstrPerson;
import com.ldq.study.annotation.entity.Gender;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class ConstructorDetail {

    /**
     * getDeclaredConstructor() 的测试函数
     * 获取类的所有的构造函数
     * 包括public构造函数/ protected 构造函数/ private构造函数
     * 非公有构造函数需要设置访问权限，方才可以实例化
     * 如果没有设置访问权限，会抛出异常
     */
    public static void testGetDeclaredConstructor() {
        try {
            // 获取 ConstrPerson 类的Class
            Class<?> cls = ConstrPerson.class;

            //获取类所有的构造方法
            Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
            for (Constructor<?> declaredConstructor : declaredConstructors) {
                System.out.println(declaredConstructor.getName() + " is "
                        + Modifier.toString(declaredConstructor.getModifiers()));
            }

            // 根据class，获取构造函数
            Constructor cst1 = cls.getDeclaredConstructor();
            Constructor cst2 = cls.getDeclaredConstructor(new Class[]{String.class});
            Constructor cst3 = cls.getDeclaredConstructor(new Class[]{String.class, int.class, Gender.class});

            // 根据构造函数，创建相应的对象
            cst1.setAccessible(true); // 因为 ConstrPerson 中 ConstrPerson()是private的，所以这里要设置为可访问
            cst2.setAccessible(true); // 因为 ConstrPerson 中 ConstrPerson()protected，所以这里要设置为可访问
            Object p1 = cst1.newInstance();
            Object p2 = cst2.newInstance("Juce");
            Object p3 = cst3.newInstance("Jody", 34, Gender.MALE);

            System.out.printf("%s: \np1=%s, \np2=%s, \np3=%s\n",
                    "getConstructor()", p1, p2, p3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * getConstructor() 的测试函数
     * 获取类所有public 修饰的构造函数
     */
    public static void testGetConstructor() {
        try {
            // 获取 ConstrPerson 类的Class
            Class<?> cls = ConstrPerson.class;

            //获取类所有 public 修饰的构造方法
            Constructor<?>[] constructors = cls.getConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor.getName() + " is "
                        + Modifier.toString(constructor.getModifiers()));
            }

            //通过传递传输类型 创建指定的构造函数
            Constructor cst1 = cls.getConstructor(new Class[]{String.class, int.class, Gender.class});

            // 根据构造函数，实例化对象
            Object p1 = cst1.newInstance("Katter", 36, Gender.MALE);
            System.out.println("p1 = " + p1);
            Constructor cst2 = cls.getConstructor(new Class[]{String.class, int.class});
            Object p2 = cst2.newInstance("Katter", 36);

            System.out.printf("%s: \np1 = %s, \np2 = %s\n",
                    "getConstructor()", p1, p2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * getEnclosingConstructor() 的测试函数
     * 如果这个类是内部类。“其它类的 构造函数中的内部类”，
     * 调用getEnclosingConstructor() 就是这个类所在的构造函数；
     * 若不存在，返回null
     */
    public static void testGetEnclosingConstructor() {
        try {
            // 获取Person类的Class
            Class<?> cls = ConstrPerson.class;

            // 根据class，调用ConstrPerson类中有内部类InnerA的构造函数
            Constructor cst = cls.getDeclaredConstructor(new Class[]{String.class, int.class});

            // 根据构造函数，创建相应的对象
            Object obj = cst.newInstance("Ammy", 18);

            System.out.printf("%s: obj=%s\n",
                    "getEnclosingConstructor()", obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        testGetDeclaredConstructor();
        System.out.println("================");
        testGetConstructor();
        System.out.println("================");
        testGetEnclosingConstructor();
    }
}
