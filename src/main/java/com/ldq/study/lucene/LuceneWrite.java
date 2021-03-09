package com.ldq.study.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.store.*;

import java.io.IOException;
import java.nio.file.Paths;

public class LuceneWrite {

    public static final String indexPath = "./data/lucene";

    /**
     * Exception in thread "main" org.apache.lucene.store.LockObtainFailedException: Lock held by this virtual
     * machine: /Users/diligent_leo/Code/java/studyJavaCode/data/lucene/write.lock
     * 	at org.apache.lucene.store.NativeFSLockFactory.obtainFSLock(NativeFSLockFactory.java:139)
     * 	at org.apache.lucene.store.FSLockFactory.obtainLock(FSLockFactory.java:41)
     * 	at org.apache.lucene.store.BaseDirectory.obtainLock(BaseDirectory.java:45)
     * 	at org.apache.lucene.index.IndexWriter.<init>(IndexWriter.java:947)
     * 	at com.ldq.study.lucene.LuceneWrite.exception(LuceneWrite.java:35)
     * 	at com.ldq.study.lucene.LuceneWrite.main(LuceneWrite.java:39)
     * @throws IOException
     */
    public static void exception() throws IOException {
        Directory dir = FSDirectory.open(Paths.get(indexPath));
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig();

        IndexWriter indexWriter = new IndexWriter(dir, indexWriterConfig);



        IndexWriterConfig indexWriterConfig2 = new IndexWriterConfig();

        IndexWriter indexWriter2 = new IndexWriter(dir,indexWriterConfig2);

    }

    public static void write() throws IOException {
        Directory dir = FSDirectory.open(Paths.get(indexPath));
        // 词法分析器
        Analyzer analyzer = new StandardAnalyzer();
        // 写操作核心配置对象
        IndexWriterConfig conf = new IndexWriterConfig(analyzer);
        conf.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
        // 写操作核心对象
        IndexWriter indexWriter = new IndexWriter(dir, conf);
        System.out.println(indexWriter);

         String doc1 = "hello world";
         String doc2 = "hello java world";
         String doc3 = "hello lucene world";
        /**
         * 操作
         */
        Document document1 = new Document();
        document1.add(new TextField("id", "1", Field.Store.YES));
        document1.add(new TextField("name", "doc1", Field.Store.YES));
        document1.add(new TextField("content", doc1, Field.Store.YES));
        indexWriter.addDocument(document1);

        Document document2 = new Document();
        document2.add(new TextField("id", "2", Field.Store.YES));
        document2.add(new TextField("name", "doc2", Field.Store.YES));
        document2.add(new TextField("content", doc2, Field.Store.YES));
        indexWriter.addDocument(document2);
        Document document3 = new Document();
        document3.add(new TextField("id", "3", Field.Store.YES));
        document3.add(new TextField("name", "doc3", Field.Store.YES));
        document3.add(new TextField("content", doc3, Field.Store.YES));
        indexWriter.addDocument(document3);
        /**
         * 收尾
         */
        indexWriter.commit();
        indexWriter.close();
        dir.close();
//        https://www.cnblogs.com/xz-blogs/p/6814506.html
    }
    public static void main(String[] args) throws Exception {
//        exception();
        write();
    }


}
