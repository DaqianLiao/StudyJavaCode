package com.ldq.study.gc.classLoader.analyse;

import java.io.IOException;
import java.io.InputStream;

/**
 * 类加载器与instanceof关键字演示
 *
 * @author
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws Exception {

        //自定义classloader
        ClassLoader myLoader = new ClassLoader() {
            @Override
            //需要重写loadClass方法
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    System.out.println("fileName = " + fileName);
                    InputStream is = getClass().getResourceAsStream(fileName);
                    //委托给父类加载
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = myLoader.loadClass("com.ldq.study.gc.classLoader.analyse.ClassLoaderTest")
                .newInstance();

        System.out.println(obj.getClass());
        System.out.println(obj instanceof com.ldq.study.gc.classLoader.analyse.ClassLoaderTest);
    }
}