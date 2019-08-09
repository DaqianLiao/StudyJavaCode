package com.ldq.study.reflexAndAnnotation.reflex;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AccessDetail {
    static class A {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    @Test
    /**
     * 可以看到关闭安全检查之后，反射执行的性能提升了几倍
     */
    public void testAccess() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        Method m = A.class.getMethod("getName", new Class[]{});

        A a = new A();
        a.setName("jack");
        int times = 10000000;
        long start = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            m.invoke(a, new Object[]{});
        }
        System.out.println("normal code tooks = " + (System.currentTimeMillis() - start));

        m.setAccessible(true);
        start = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            m.invoke(a, new Object[]{});
        }
        System.out.println("setAccessible tooks = " + (System.currentTimeMillis() - start));

    }
}
