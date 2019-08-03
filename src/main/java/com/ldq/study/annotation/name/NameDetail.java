package com.ldq.study.annotation.name;

import com.ldq.study.annotation.entity.Person;
import org.junit.Test;

/**
 * 1、除了数组跟匿名类外，getCanonicalName(),
 * getName()其它都相同（源码注释了还有本地类）,而getSimpleName()只是截取前面的包部分，
 * 只留下java代码中类名部分。
 * 2、数组中getName()通过[L表示数组，getCanonicalName()通过在定义的类型后面加上[]表示数组，
 * 而getSimpleName()只是去掉getCanonicalName()返回结果前面的包部分。因此他们两个很相似，
 * 就像父子关系一样，getCanonicalName返回为null，getSimpleName就是空字符串。
 * 3、匿名类中，因为匿名类在java语言规范中是不能呈现出类结构的，它的位置不能通过名称表示出来，
 * 所以getCanonicalName()方法返回的是null，同理getSimpleName()方法返回的是代码默认的空字符串，
 * getName()返回通过$后面加上迭代数表示。
 */
public class NameDetail {
    static class Inn {

    }

    @Test
    public void log4jTest() {
        System.out.println("-----------内部类----------------");
        Class inn = Inn.class;
        System.out.println(inn.getCanonicalName());
        System.out.println(inn.getName());
        System.out.println(inn.getSimpleName());
        System.out.println(inn.getTypeName());

        System.out.println("-----------匿名类----------------");

        Class anonymousClass = new Object() {}.getClass();
        System.out.println(anonymousClass.getCanonicalName());
        System.out.println(anonymousClass.getName());
        System.out.println(anonymousClass.getSimpleName());
        System.out.println(anonymousClass.getTypeName());

        System.out.println("-----------数组类----------------");
        Class arrayClass = new Object[1].getClass();
        System.out.println(arrayClass.getCanonicalName());
        System.out.println(arrayClass.getName());
        System.out.println(arrayClass.getSimpleName());
        System.out.println(arrayClass.getTypeName());
    }

    @Test
    public void getClassName() {
        try {
            // 方法1：Class.forName("类名字符串")  （注意：类名字符串必须是全称，包名+类名）
            Class<?> cls1 = Class.forName("com.ldq.study.annotation.entity.Person");
            //Class<Person> cls1 = Class.forName("com.ldq.study.annotation.entity.Person");

            // 方法2：类名.class
            Class cls2 = Person.class;

            // 方法3：实例对象.getClass()
            Person person = new Person();
            Class cls3 = person.getClass();

            // 方法4："类名字符串".getClass()
            String str = "com.ldq.study.annotation.entity.Person";
            Class cls4 = str.getClass();

            System.out.printf(" cls1=%s,\n cls2=%s,\n cls3=%s,\n cls4=%s\n", cls1, cls2, cls3, cls4);
            //true
            System.out.println(cls1 == cls2 && cls1 == cls3 );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



