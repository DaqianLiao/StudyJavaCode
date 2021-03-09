package com.ldq.study.lucene;



import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.FSLockFactory;
import org.apache.lucene.store.NIOFSDirectory;

public class IndexCreate {
    final static String tmpData = "/Users/diligent_leo/Code/java/studyJavaCode/data/tmp";
    final static String dirData = "/Users/diligent_leo/Code/java/studyJavaCode/data/lucenedir";
    public static void main(String[] args) {
        makeIndexes();
        mergeIndexFiles();
        searchIndexFileSize();

    }

    /**
     * 创建索引
     */
    public static void makeIndexes() {

        /**
         * 创建索引文件
         */
        IndexWriter writer = null;
        Directory directory = null;
        String doc1 = "hello world";
        String doc2 = "hello java world";
        String doc3 = "hello lucene world";
        /**
         * 操作
         */
        try {
            Path path = new File(tmpData).toPath();
            directory = FSDirectory.open(path);
            writer = new IndexWriter(directory, new IndexWriterConfig(
                    new StandardAnalyzer()));
            Document document1 = new Document();
            document1.add(new TextField("id", "1", Field.Store.YES));
            document1.add(new TextField("name", "doc1", Field.Store.YES));
            document1.add(new TextField("content", doc1, Field.Store.YES));
            writer.addDocument(document1);
            Document document2 = new Document();
            document2.add(new TextField("id", "2", Field.Store.YES));
            document2.add(new TextField("name", "doc2", Field.Store.YES));
            document2.add(new TextField("content", doc2, Field.Store.YES));
            writer.addDocument(document2);
            Document document3 = new Document();
            document3.add(new TextField("id", "3", Field.Store.YES));
            document3.add(new TextField("name", "doc3", Field.Store.YES));
            document3.add(new TextField("content", doc3, Field.Store.YES));
            writer.addDocument(document3);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.commit();
                writer.close();
                directory.close();
                System.out.println("索引创建成功!");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 合并索引文件
     */
    public static void mergeIndexFiles() {
        IndexWriter writer = null;
        Directory directory = null;
        Directory tempDir = null;
        try {
            Path path = new File(dirData).toPath();
            directory = FSDirectory.open(path);
            Path temp = new File(tmpData).toPath();
            tempDir = FSDirectory.open(temp);
            tempDir = new NIOFSDirectory(Paths.get(tmpData), FSLockFactory.getDefault());
            writer = new IndexWriter(directory,
                    new IndexWriterConfig(new StandardAnalyzer()));
            writer.addIndexes(tempDir);
            writer.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                writer.close();
                directory.close();
                tempDir.close();
                System.out.println("索引文件合并成功!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void searchIndexFileSize() {
        Directory directory = null;
        try {
            Path path = new File(dirData).toPath();
            directory = FSDirectory.open(path);
            IndexReader reader=DirectoryReader.open(directory);
            System.out.println(reader.maxDoc());
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                directory.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}