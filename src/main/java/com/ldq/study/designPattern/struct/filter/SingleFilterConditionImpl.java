package com.ldq.study.designPattern.struct.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义过滤条件
 */
public class SingleFilterConditionImpl implements FilterCondition {
    private String sex = "single";

    @Override
    public List<Person> filter(List<Person> persons) {
        List<Person> filter = new ArrayList<>();
        for (Person person : persons) {
            if (sex.equalsIgnoreCase(person.getMarital())) {
                filter.add(person);
            }
        }

        return filter;
    }
}
