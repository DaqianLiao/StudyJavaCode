package com.ldq.study.annotation.extend;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by diligent_leo on 2016/12/24.
 */
public class ParseAnnotation {
    public static void main(String[] args) {
        //1 使用类加载器
        try {
            Class aClass = Class.forName("com.ldq.study.annotation.extend.Child");
            //2 找到类上面的注解

            boolean isClassAnnotation = aClass.isAnnotationPresent(Desciption.class);
            if (isClassAnnotation) {

                //3 拿到注解实例
                Desciption desciption = (Desciption) aClass.getAnnotation(Desciption.class);
                System.out.println(desciption.value());
                System.out.println(desciption.author());
            }

            //4 找到方法上的注解
            Method[] methodsList = aClass.getMethods();
            for(Method method :methodsList){
                boolean isMethodAnnotation = method.isAnnotationPresent(MethodDesc.class);
                if (isMethodAnnotation) {
                    MethodDesc methodDescription = method.getAnnotation(MethodDesc.class);
                    System.out.println(methodDescription.name());
                }
            }
            //5 另外一种解析方法
            for(Method method : methodsList){
                Annotation[] annotationList = method.getAnnotations();
                for(Annotation annotation : annotationList){
                    if (annotation instanceof Desciption) {
                        Desciption descptionAnn = (Desciption) annotation;
                        System.out.println(descptionAnn.value());
                    }
                }
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
