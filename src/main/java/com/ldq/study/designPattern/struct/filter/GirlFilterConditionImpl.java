package com.ldq.study.designPattern.struct.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义过滤条件
 */
public class GirlFilterConditionImpl implements FilterCondition {
    private String sex = "girl";

    @Override
    public List<Person> filter(List<Person> persons) {
        List<Person> filter = new ArrayList<>();
        for (Person person : persons) {
            if (sex.equalsIgnoreCase(person.getSex())) {
                filter.add(person);
            }
        }

        return filter;
    }
}
