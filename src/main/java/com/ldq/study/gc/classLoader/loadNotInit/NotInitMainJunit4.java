package com.ldq.study.gc.classLoader.loadNotInit;

import com.ldq.study.gc.classLoader.entity.SubClass;
import org.junit.Test;

public class NotInitMainJunit4 {

    /**
     * 使用junit4测试代码时，在方法上加@Test注解，
     * 相当于执行new MainJunit4().method()
     * 会触发当前类的加载
     */
    public NotInitMainJunit4(){
        System.out.println("init Main");
    }

    /**
     * 子类引用父类的静态字段，不会导致子类初始化
     */
    @Test
    public void subClassUseSuperClassStaticField(){
        System.out.println(SubClass.VALUE);
    }

}
