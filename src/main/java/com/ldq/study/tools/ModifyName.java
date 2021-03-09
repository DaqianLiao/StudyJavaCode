package com.ldq.study.tools;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ModifyName {
    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.arch"));
        String path = "/Users/diligent_leo/Desktop/09 JAVA开发中的热点技术剖析";
        showFiles(path);
        filter(path,"[52download.cn]");
        showFiles(path);
    }

    public static void showFiles(String path){
        File file = new File(path);
        List<File> files = getFiles(file);
        files.forEach(System.out::println);
    }

    public static List<File> getFiles(File file){
        List<File> files = new ArrayList<>();
        if (file.isDirectory()) {
            File[] innerFiles = file.listFiles();
            for (File file1 : innerFiles) {
                files.addAll(getFiles(file1));
            }
        }else{
            files.add(file);
        }
        return files;
    }

    public static void filter(String path,String filter){
        File file = new File(path);
        List<File> files = getFiles(file);
        files.stream()
                .filter(x -> x.getAbsolutePath().contains(filter))
                .forEach(x -> x.renameTo(new File(x.getAbsolutePath().replace(filter, ""))));

    }

}
