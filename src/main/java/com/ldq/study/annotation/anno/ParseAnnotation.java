package com.ldq.study.annotation.anno;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by diligent_leo on 2016/12/24.
 */
public class ParseAnnotation {

    /**
     * 　取值(ElementType)有：
     *
     * 　　　　1.CONSTRUCTOR:用于描述构造器
     * 　　　　2.FIELD:用于描述域
     * 　　　　3.LOCAL_VARIABLE:用于描述局部变量
     * 　　　　4.METHOD:用于描述方法
     * 　　　　5.PACKAGE:用于描述包
     * 　　　　6.PARAMETER:用于描述参数
     * 　　　　7.TYPE:用于描述类、接口(包括注解类型) 或enum声明
     * @param args
     */
    public static void main(String[] args) {
        //1 使用类加载器
        try {
            Class aClass = Class.forName("com.ldq.study.annotation.base.Child");

            //2 找到类上面的注解
            boolean isClassAnnotation = aClass.isAnnotationPresent(Description.class);
            if (isClassAnnotation) {

                //3 拿到注解实例
                Description description = (Description) aClass.getAnnotation(Description.class);
                System.out.println(description.value());
                System.out.println(description.author());
            }

            //4 找到方法上的注解
            System.out.println("============find methods:============");
            Method[] methodsList = aClass.getMethods();
            for(Method method :methodsList){
                System.out.println("method: " + method.getName());
                boolean isMethodAnnotation = method.isAnnotationPresent(Description.class);
                if (isMethodAnnotation) {
                    Description methodDescription = method.getAnnotation(Description.class);
                    System.out.println(methodDescription.value());
                }
            }

            //5 另外一种解析方法
            System.out.println("============getDeclaredMethods :============");
            Method[] declaredMethods = aClass.getDeclaredMethods();
            for(Method method : declaredMethods){
                System.out.println("DeclaredMethods: " + method.getName());
                Annotation[] annotationList = method.getAnnotations();
                for(Annotation annotation : annotationList){
                    if (annotation instanceof Description) {
                        Description descriptionAnn = (Description) annotation;
                        System.out.println(descriptionAnn.value());
                    }
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
