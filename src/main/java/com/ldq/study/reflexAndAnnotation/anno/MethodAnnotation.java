package com.ldq.study.reflexAndAnnotation.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 常用的方法上的注解
 * GetMapping/RequestMapping/SetMapping
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodAnnotation {
    String name() default  "method name";
    String value() default "method value";
}
