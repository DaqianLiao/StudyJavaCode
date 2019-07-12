package com.ldq.study.designPattern.struct.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义男性过滤器，实现过滤接口
 */
public class ManFilterConditionImpl implements FilterCondition {
    private String sex = "man";

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
