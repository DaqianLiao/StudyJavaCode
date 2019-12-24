package com.ldq.study.annotation.extend;

import java.lang.annotation.*;


/**
 * Created by diligent_leo on 2016/12/23.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Desciption {

    String desc();

    String author();

    int age() default 18;

    String value();
}
