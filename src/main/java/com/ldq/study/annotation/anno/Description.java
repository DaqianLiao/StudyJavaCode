package com.ldq.study.annotation.anno;

import java.lang.annotation.*;


/**
 * Created by diligent_leo on 2016/12/23.
 */
@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description {

    String desv();

    String author();

    int age() default 18;

    String value();
}
