package com.ldq.study.util.lang3;

import org.apache.commons.lang3.exception.ContextedRuntimeException;
import org.junit.Test;

public class ExceptionTest {
    @Test
    public void meaning() throws Exception {
        //官方的异常，只能包含文本信息，过于单一，不能够传递过多参数，而这个版本的异常类增加了这项功能。
    }

    @Test
    public void example() throws Exception {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            throw new ContextedRuntimeException("Error posting account transaction", e)
                    .addContextValue("Account Number", 1)
                    .addContextValue("Account Number", 1)
                    .setContextValue("Account Number", 3)//清空原来的，替换成现在的
                    .addContextValue("Amount Posted", 1)
                    .addContextValue("Previous Balance", 1);
        }
    }

    @Test
    public void util() throws Exception {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
