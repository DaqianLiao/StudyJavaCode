package com.ldq.study.annotation.extend;
import	java.lang.annotation.RetentionPolicy;
import	java.lang.annotation.Retention;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodDesc {
    String name() default "method";
}
