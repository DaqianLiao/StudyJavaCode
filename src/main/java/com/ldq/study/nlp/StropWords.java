package com.ldq.study.nlp;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StropWords {

    public static List<String> getStopWords(String path) {
        return getStopWords(path, true);
    }


    public static List<String> getStopWords(String path, boolean isPrint) {
        List<String> stopWords = new ArrayList<>();
        try {
            stopWords = FileUtils.readLines(new File(path));
            if (isPrint) {
                System.out.println(stopWords.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stopWords;
    }

    public static void main(String[] args) {
        String path = "data/stopwords/中文停用词表.txt";
        getStopWords(path);
    }
}
