package com.ldq.study.io.readProperties;

import org.apache.commons.io.Charsets;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * Properties内部本质上是一个Hashtable.
 *
 * 创建Properties实例；
 * 调用load()读取文件；
 * 调用getProperty()获取配置。
 */
public class WriteReadPropertiesCase {

    @Test
    /**
     * 中文编码会乱码
     */
    public void load() throws IOException {
        String f = "setting.properties";
        Properties props = new Properties();
        props.load(getClass().getClassLoader().getResourceAsStream(f));
        System.out.println(props);
    }

    @Test
    /**
     * 解决乱码
     */
    public void loadChinese() throws IOException {
        String f = "setting.properties";
        Properties props = new Properties();
        InputStream is = getClass().getClassLoader().getResourceAsStream(f);
        //解决读取properties文件中产生中文乱码的问题
        BufferedReader bf = new BufferedReader(
                new  InputStreamReader(is, Charsets.UTF_8.name()));
        props.load(bf);
        System.out.println(props);
    }

    @Test
    public void store() throws IOException {
        String f = "setting.properties";
        Properties props = new Properties();
        URL is = getClass().getClassLoader().getResource(f);

        props.setProperty("url", "http://www.liaoxuefeng.com");
        props.setProperty("language", "Java");
        props.setProperty("name", "东方不败");
        props.store(new FileOutputStream(new File(is.getPath())), "这是写入的properties注释");
        loadChinese();
    }

}
