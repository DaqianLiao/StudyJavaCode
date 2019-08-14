package com.ldq.study.util.commomIo;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.TeeOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IOUtilCase {
    private static final String BASE_PATH = "data/io/";

    public static void main(String[] args) throws IOException {
        String path = BASE_PATH + "demo.txt";
        FileNameUtils(path);
        fileWriter(path);
        fileReader(path);
        readFromURL();
        other();
    }

    private static void fileWriter(String path) throws IOException {
        //定义一个文件
        Charset charset = StandardCharsets.UTF_8;
        String str = "你好,世界\n hello world";
        List<String> lines = Stream.of("你好,世界", "hello, world").collect(Collectors.toList());

        File file = new File(path);
        //01.把内容写进文件
        FileUtils.write(file, str);
        //02.把内容写进文件,用UTF-8编码
        FileUtils.write(file, str, charset);
        //03.把内容追加进文件
        FileUtils.write(file, str, true);
        //04.把一个List写进文件,List的每一个元素是一行
        FileUtils.writeLines(file, lines);
        FileUtils.writeLines(file, lines, true);
        FileUtils.writeLines(file, "UTF-8", lines, true);
        //05.写入二进制数据
        FileUtils.writeByteArrayToFile(file, str.getBytes());
        //06.还有writeStringtoFile
        FileUtils.writeStringToFile(file, str, charset);
    }

    private static void fileReader(String path) throws IOException {
        // 定义一个文件
        File f = new File(path);
        String encoding = "UTF-8";

        // 01.把文件的所有内容放到String里,第二个参数是编码可选的..
        System.out.println("-------------把文件的所有内容读到String中---------");
        String readFileToString = FileUtils.readFileToString(f, encoding);
        System.out.println(readFileToString);

        // 02.把文件的所有内容按行放到List中.第二个参数是编码,可选
        System.out.println("-------------把文件的所有内容按行读到List中---------");
        List<String> readLines = FileUtils.readLines(f, encoding);
        readLines.forEach(System.out::println);

        // 03.读成字节数组(一般用于二进制文件)
        System.out.println("-------------把文件的所有内容读成一个byteArray---------");
        byte[] readFileToByteArray = FileUtils.readFileToByteArray(f);
        System.out.println(new String(readFileToByteArray, encoding));

    }

    private static void FileNameUtils(String path) {
        File file = new File(path);
        // 返回文件后缀名
        System.out.println(FilenameUtils.getExtension(file.toString()));
        // 返回文件名，不包含后缀名
        System.out.println(FilenameUtils.getBaseName(file.toString()));
        // 返回文件名，包含后缀名
        System.out.println(FilenameUtils.getName(file.toString()));
        // 获取文件的路径（不带文件名）
        System.out.println(FilenameUtils.getFullPath(file.toString()));
        // 路径分隔符改成unix系统格式的，即/
        System.out.println(FilenameUtils.separatorsToUnix(file.toString()));
        // 检查文件后缀名是不是传入参数(List<String>)中的一个
        System.out.println(FilenameUtils.isExtension("txt", new ArrayList<>()));
    }

    private static void readFromURL() throws IOException {
        String encoding = "UTF-8";
        InputStream inputStream = new URL("https://www.baidu.com/").openStream();
        // 01读取链接地址网页
        String s = IOUtils.toString(inputStream, encoding);
        System.out.println(s);
        String gif = BASE_PATH + "test.gif";
        IOUtils.write(s, new FileOutputStream(new File(gif)));
        FileUtils.writeByteArrayToFile(new File(gif), s.getBytes());

        // 04保存网络文件到本地文件
        FileUtils.copyURLToFile(new URL("http://www.163.com"), new File(BASE_PATH + "163.html"));

    }


    public static void other() throws IOException {
        String source = BASE_PATH + "source.txt";
        String destination = BASE_PATH + "destination.txt";
        File src = new File(source);
        File dest = new File(destination);

        FileUtils.touch(src);
        FileUtils.touch(dest);
        // 01文件copy操作
        FileUtils.copyFile(src, dest);
        //将文件复制到别的目录
        FileUtils.copyFileToDirectory(src, new File("data/io/copy"));


        String deletePath = BASE_PATH + "delete/";
        String deleteFile1 = deletePath + "testFile1.txt";
        String deleteFile2 = deletePath + "testFile2.txt";
        // 07目录操作（不存在,新建，存在,修改文件修改时间）
        FileUtils.touch(new File(deleteFile1));
        FileUtils.touch(new File(deleteFile2));
        // 03删除文件
        FileUtils.forceDelete(new File(deleteFile2));
        // 05清空目录下的文件
        FileUtils.cleanDirectory(new File(deletePath));
//        // 06删除目录和目录下的文件
//        FileUtils.deleteDirectory(new File(deletePath));
//        FileUtils.deleteQuietly(new File(deletePath));

// 07目录操作（不存在,新建，存在,修改文件修改时间）
        // 08相同的内容写入不同的文本
        File test1 = new File(deleteFile1);
        File test2 = new File(deleteFile2);

        FileUtils.touch(test1);
        FileUtils.touch(test2);
        TeeOutputStream teeOutputStream = new TeeOutputStream(new FileOutputStream(test1), new FileOutputStream(test2));
        teeOutputStream.write("One Two Three, Test".getBytes());
        teeOutputStream.flush();

        // 09目录大小
        long sizeOf = FileUtils.sizeOf(new File(BASE_PATH));
        long sizeOfDirectory = FileUtils.sizeOfDirectory(new File(BASE_PATH));
        System.out.println("sizeOfDirectory = " + sizeOfDirectory);
        System.out.println("sizeOf = " + sizeOf);
        System.out.println(sizeOf == sizeOfDirectory);
    }

}
