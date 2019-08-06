package com.ldq.study.reflexAndAnnotation.anno;

import com.ldq.study.reflexAndAnnotation.entity.PersonAnno;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@ClassAnnotation(age = 25)
public class Anno {

    @Test
    public void getNoAnnotation() throws ClassNotFoundException {
        String person = "com.ldq.study.reflexAndAnnotation.entity.Person";
        Class<?> aClass = Class.forName(person);
        Annotation[] annotations = aClass.getAnnotations();
        System.out.println("reflexAndAnnotation size = " + annotations.length);
        for (Annotation annotation : annotations) {
            System.out.println("reflexAndAnnotation = " + annotation);
        }
    }

    @Test
    public void getAnnotation() throws ClassNotFoundException {
        String person = "com.ldq.study.reflexAndAnnotation.entity.Child";
        Class<?> aClass = Class.forName(person);
        Annotation[] annotations = aClass.getAnnotations();
        System.out.println("reflexAndAnnotation size = " + annotations.length);
        for (Annotation annotation : annotations) {
            System.out.println("reflexAndAnnotation = " + annotation);
            System.out.println(annotation.annotationType().getName());
            System.out.println("(reflexAndAnnotation instanceof Description) = " + (annotation instanceof Description));
            if (annotation instanceof Description) {
                Description annotation1 = (Description) annotation;
                System.out.println("annotation1.value() = " + annotation1.value());
                System.out.println("annotation1.author() = " + annotation1.author());
                System.out.println("annotation1.desv() = " + annotation1.desv());
                System.out.println("annotation1.age() = " + annotation1.age());
            }

        }
    }

    /**
     * Class注解测试
     */
    @Test
    public void test1() {
        Class c = Anno.class;
        ClassAnnotation ca = (ClassAnnotation) c.getAnnotation(ClassAnnotation.class);
        if (ca == null) {
            System.out.println("UnKnown!!");
        } else {
            System.out.println(" age:" + ca.age());
        }
    }

    /**
     * Method注解测试
     */
    @Test
    public void test2() {
        Class c = PersonAnno.class;
        Method[] methodAnnotation = c.getDeclaredMethods();
        for (Method me : methodAnnotation) {
            MethodAnnotation method = me.getAnnotation(MethodAnnotation.class);
            if (method == null) {
                System.out.println("UnKnown!!");
            } else {
                System.out.println(method.name());
                System.out.println(method.value());
            }
        }
    }

    /**
     * Field注解测试
     */
    @Test
    public void test3() throws IllegalAccessException, InstantiationException {
        Class c = PersonAnno.class;
        Field[] fields = c.getDeclaredFields();
        Object instance = c.newInstance();
        System.out.println("size = " + fields.length);
        System.out.println("被注解FieldAnnotation注解的属性：");
        for (Field field : fields) {
            System.out.println("-----------------------------------");
            System.out.println("属性名称：" + field.getName());
            //由于字段属性为private，需要设置访问权限
            field.setAccessible(true);
            System.out.println("属性值：" + field.get(instance));
            descFiledInfo(field, instance);
        }
    }

    /**
     * 分别获取注解的详细信息
     *
     * @param field
     */
    public void descFiledInfo(Field field, Object instance) throws IllegalAccessException {
        FieldAnnotation fa = field.getAnnotation(FieldAnnotation.class);
        if (fa == null) {
            System.out.println("UnKnown!!");
        } else {
            if ("name".equals(field.getName())) {
                field.set(instance, fa.name());
                System.out.println(field.getName() + " = " + field.get(instance));
            } else {
                field.set(instance, fa.value());
                System.out.println(field.getName() + " = " + field.get(instance));
            }
        }
    }


}
