package com.ldq.study.reflexAndAnnotation.entity;

import com.ldq.study.reflexAndAnnotation.anno.FieldAnnotation;
import com.ldq.study.reflexAndAnnotation.anno.MethodAnnotation;

public class PersonAnno {
    @FieldAnnotation
    private String name;

    @FieldAnnotation
    private String address;

    @MethodAnnotation
    public void print(){}
}
