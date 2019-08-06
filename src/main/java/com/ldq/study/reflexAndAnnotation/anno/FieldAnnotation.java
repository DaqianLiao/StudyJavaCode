package com.ldq.study.reflexAndAnnotation.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 长用在字段上的注解
 * NotEmpty/NotBlank/NotNull
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldAnnotation {
    String name() default  "field name";
    String value() default "field value";
}
