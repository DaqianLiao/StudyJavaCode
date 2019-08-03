package com.ldq.study.annotation.anno;

import org.junit.Test;

import java.lang.annotation.Annotation;

public class Anno {

    @Test
    public void getNoAnnotation() throws ClassNotFoundException {
        String person = "com.ldq.study.annotation.entity.Person";
        Class<?> aClass = Class.forName(person);
        Annotation[] annotations = aClass.getAnnotations();
        System.out.println("annotation size = " + annotations.length);
        for (Annotation annotation : annotations) {
            System.out.println("annotation = " + annotation);
        }
    }
    
    @Test
    public void getAnnotation() throws ClassNotFoundException {
        String person = "com.ldq.study.annotation.entity.Child";
        Class<?> aClass = Class.forName(person);
        Annotation[] annotations = aClass.getAnnotations();
        System.out.println("annotation size = " + annotations.length);
        for (Annotation annotation : annotations) {
            System.out.println("annotation = " + annotation);
            System.out.println(annotation.annotationType().getName());
            System.out.println("(annotation instanceof Description) = " + (annotation instanceof Description));
            if(annotation instanceof Description){
                Description annotation1 = (Description) annotation;
                System.out.println("annotation1.value() = " + annotation1.value());
                System.out.println("annotation1.author() = " + annotation1.author());
                System.out.println("annotation1.desv() = " + annotation1.desv());
                System.out.println("annotation1.age() = " + annotation1.age());
            }

        }
    }
}
