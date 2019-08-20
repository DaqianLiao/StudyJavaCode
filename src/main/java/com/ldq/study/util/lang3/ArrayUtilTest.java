package com.ldq.study.util.lang3;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import java.util.Arrays;

public class ArrayUtilTest {
    @Test
    public void add() throws Exception {
        String[] array = new String[]{"a", "b", "c"};
        String[] theNew = ArrayUtils.add(array, "a");
        System.out.println(Arrays.toString(theNew));
        ArrayUtils.reverse(theNew);
        System.out.println(Arrays.toString(theNew));
    }
}
