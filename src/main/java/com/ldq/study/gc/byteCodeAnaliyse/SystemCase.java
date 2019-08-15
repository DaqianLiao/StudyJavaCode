package com.ldq.study.gc.byteCodeAnaliyse;

import com.ldq.study.finalDemo.Person;
import org.junit.Test;

import java.util.Arrays;
import java.util.Properties;

/**
 *
 * https://blog.csdn.net/qq_34755766/article/details/82963353
 *
 */
public class SystemCase {

    @Test
    public void systemProperty() {
        System.out.println("java 运行时环境版本：" + System.getProperty("java.version"));
        System.out.println("java 运行时环境供应商：" + System.getProperty("java.vendor"));
        System.out.println("java 运行时环境规范版本：" + System.getProperty("java.specification.version"));
        System.out.println("java 运行时环境规范供应商：" + System.getProperty("java.specification.vendor"));
        System.out.println("java 运行时环境规范名称：" + System.getProperty("java.specification.name"));
        System.out.println("操作系统名称：" + System.getProperty("os.name"));
        System.out.println("操作系统架构：" + System.getProperty("os.arch"));
        System.out.println("操作系统版本：" + System.getProperty("os.version"));
        System.out.println("用户账户名称：" + System.getProperty("user.name"));
        System.out.println("用户主目录：" + System.getProperty("user.home"));
        System.out.println("当前工作目录：" + System.getProperty("user.dir"));
    }

    @Test
    public void allProperties() {
        Properties properties = System.getProperties();
        properties.forEach((x, y) -> System.out.println(String.format("key = %s, value = %s", x, y)));
    }

    @Test
    public void copy() {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {9, 8, 7, 6, 5};

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        /**
         * 参数详解：
         * 参数1：被复制的数组arr1
         * 参数2: arr1中要复制的起始位置
         * 参数3: 目标数组arr2
         * 参数4: 目标数组的复制起始位置
         * 参数5: 目标数组的复制结束位置
         *
         * 当复制的长度超过数组的长度时，会报错
         * 通常用来复制同长度数组
         */
        System.arraycopy(arr1, 1, arr2, 0, 3);
        System.out.println(Arrays.toString(arr2));
    }

    @Test
    public void time() {
        System.out.println("当前的毫秒数: " + System.currentTimeMillis());
        /**
         * 获取的不是纳秒数，而是微毫秒数，比毫秒多一位
         * 目的是比毫秒更加精确
         * 不能用来代替时间，只能用来计算差值
         */
        System.out.println("当前的微毫秒数: " + System.nanoTime());
    }

    @Test
    /**
     * -verbose:gc
     */
    public void gc() {
        Person person = new Person("lucy", "man", 25);
        System.out.println(person);
        person = null;
        System.gc();
    }

    @Test
    /**
     * exit(int)方法是终止当前正在运行的java虚拟机。
     * 参数是状态码。
     * 非0的状态码表示异常终止，0表是终止。
     * 而且，该方法永远不会正常返回
     *
     * 这里会破坏finally的语义，之前的理解中，finally一定会执行
     * 但是当虚拟机退出方法时，finally中的代码不会执行
     */
    public void exit(){
        try {
            System.out.println("this is try");
            System.exit(0);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            System.out.println("this is finally");
        }

    }

}
