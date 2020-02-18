package com.ldq.study.tools;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ModifyName {
    public static void main(String[] args) {
        String path = "/Users/diligent_leo/Desktop/Flume-徐培成";
        File file = new File(path);
        List<File> files = getFiles(file);
        files.forEach(System.out::println);
        filter(files,"大数据教育_徐培成_");
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

    public static void filter(List<File> files,String filter){
        files.stream()
                .filter(x -> x.getAbsolutePath().contains(filter))
                .forEach(x -> x.renameTo(new File(x.getAbsolutePath().replace(filter, ""))));

    }

}
