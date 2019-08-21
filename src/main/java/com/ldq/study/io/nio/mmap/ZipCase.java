package com.ldq.study.io.nio.mmap;

import org.junit.Test;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * https://www.toutiao.com/i6727158098886181384/?tt_from=mobile_qq&utm_campaign=client_share&timestamp=1566348158&app=news_article&utm_source=mobile_qq&utm_medium=toutiao_android&req_id=201908210842380100230761355136095&group_id=6727158098886181384
 */
public class ZipCase {
    public static String JPG_FILE_PATH = "data/io/compress/smile.jpg";

    //zip压缩包所存放的位置
    public static String ZIP_FILE = "data/io/compress/hu.zip";

    //所要压缩的文件
    public static File JPG_FILE = null;

    //文件大小
    public static long FILE_SIZE = 0;

    //文件名
    public static String FILE_NAME = "";

    //文件后缀名
    public static String SUFFIX_FILE = "";

    static {

        File file = new File(JPG_FILE_PATH);

        JPG_FILE = file;

        FILE_NAME = file.getName();

        FILE_SIZE = file.length();

        SUFFIX_FILE = file.getName().substring(file.getName().indexOf('.'));
    }

    @Test
    /**
     * 调用本地方法与原生操作系统进行交互，从磁盘中读取数据。
     * 每读取一个字节的数据就调用一次本地方法与操作系统交互
     */
    public void zipFileNoBuffer() {
        Path path = Paths.get(ZIP_FILE);
        File zipFile = path.toFile();
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile))) {
//            //开始时间
            long beginTime = System.currentTimeMillis();
            for (int i = 0; i < 10; i++) {
                try (InputStream input = new FileInputStream(JPG_FILE)) {
                    zipOut.putNextEntry(new ZipEntry(FILE_NAME + i));
                    int temp = 0;
                    while ((temp = input.read()) != -1) {
                        zipOut.write(temp);
                    }
                }
            }
            printInfo(beginTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    /**
     * 缓冲区在第一次调用read()方法的时候会直接从磁盘中将数据直接读取到内存中。
     * 随后再一个字节一个字节的慢慢返回。
     */
    public void zipFileBuffer() {
        File zipFile = new File(ZIP_FILE);

        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(zipOut)) {
//            开始时间
            long beginTime = System.currentTimeMillis();

            for (int i = 0; i < 10; i++) {
                try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(JPG_FILE))) {
                    zipOut.putNextEntry(new ZipEntry(FILE_NAME + i));
                    int temp = 0;
                    while ((temp = bufferedInputStream.read()) != -1) {
                        bufferedOutputStream.write(temp);

                    }
                }
            }
            printInfo(beginTime);
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    @Test
    /**
     * 没有使用ByteBuffer进行数据传输，而是使用了transferTo的方法。这个方法是将两个通道进行直连
     * 使用transferTo的效率比循环一个Channel读取出来然后再循环写入另一个Channel好。
     * 操作系统能够直接传输字节从文件系统缓存到目标的Channel中，而不需要实际的copy阶段
     */
    public void zipFileChannel() {
        //开始时间
        long beginTime = System.currentTimeMillis();
        File zipFile = new File(ZIP_FILE);
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
             WritableByteChannel writableByteChannel = Channels.newChannel(zipOut)) {
            for (int i = 0; i < 10; i++) {
                try (FileChannel fileChannel = new FileInputStream(JPG_FILE).getChannel()) {
                    zipOut.putNextEntry(new ZipEntry(i + SUFFIX_FILE));
                    fileChannel.transferTo(0, FILE_SIZE, writableByteChannel);
                }
            }
            printInfo(beginTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void zipFileMap() {
//        开始时间
        long beginTime = System.currentTimeMillis();
        File zipFile = new File(ZIP_FILE);
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
             WritableByteChannel writableByteChannel = Channels.newChannel(zipOut)) {

            for (int i = 0; i < 10; i++) {
                zipOut.putNextEntry(new ZipEntry(i + SUFFIX_FILE));
//                内存中的映射文件
                MappedByteBuffer mappedByteBuffer = new RandomAccessFile(JPG_FILE_PATH, "r").getChannel()
                        .map(FileChannel.MapMode.READ_ONLY, 0, FILE_SIZE);
                writableByteChannel.write(mappedByteBuffer);
            }

            printInfo(beginTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void printInfo(long beginTime) {
        //耗时
        long timeConsum = (System.currentTimeMillis() - beginTime);

        System.out.println("fileSize:" + FILE_SIZE / 1024 / 1024 * 10 + "M");
        System.out.println("consum time:" + timeConsum);
    }
}
