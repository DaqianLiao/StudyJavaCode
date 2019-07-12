package com.ldq.study.designPattern.struct.filter;

import java.util.List;

/**
 * 定义过滤接口
 */
public interface FilterCondition {
    List<Person> filter(List<Person> persons);
}
