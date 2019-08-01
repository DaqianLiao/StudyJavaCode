package com.ldq.study.nlp;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StropWords {

    public static List<String> getStopWords(String path ){
        List<String> stopWords = new ArrayList<>();
        try {
            stopWords = FileUtils.readLines(new File(path));
            System.out.println(stopWords.toString());
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
