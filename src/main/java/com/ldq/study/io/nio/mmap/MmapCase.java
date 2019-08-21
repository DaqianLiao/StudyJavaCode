package com.ldq.study.io.nio.mmap;

import org.junit.Test;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class MmapCase {

    @Test
    public void readWithNio() throws IOException {
        Path path = Paths.get("data/mmap/readMmapFile.txt");
        /**
         * mode 为文件映射模式，分为三种：
         *
         * MapMode.READ_ONLY（只读），任何试图修改缓冲区的操作将导致抛出 ReadOnlyBufferException 异常。
         * MapMode.READ_WRITE（读/写），任何对缓冲区的更改都会在某个时刻写入文件中。需要注意的是，其他映射同一个文件的程序可能不能立即看到这些修改，多个程序同时进行文件映射的行为依赖于操作系统。
         * MapMode.PRIVATE（私有）， 对缓冲区的更改不会被写入到该文件，任何修改对这个缓冲区来说都是私有的。
         * 2）position 为文件映射时的起始位置。
         *
         * 3）size 为要映射的区域的大小，必须是非负数，不得大于Integer.MAX_VALUE。
         */
        CharBuffer charBuffer = null;
        try (FileChannel fileChannel = FileChannel.open(path)) {
            MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY,
                    0, fileChannel.size());
            if (mappedByteBuffer != null) {
                charBuffer = Charset.forName("UTF-8").decode(mappedByteBuffer);
            }
            System.out.println(charBuffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    //普通输入流
    public void readWithInputStream() {
        Path path = Paths.get("data/mmap/readMmapFile.txt");
        InputStream in;

        try (InputStream is = Files.newInputStream(path);
             InputStreamReader reader = new InputStreamReader(is)) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print(((char) (c)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    //带缓冲的输入流
    public void readWithBufferedInputStream() {
        Path path = Paths.get("data/mmap/readMmapFile.txt");

        try (InputStream is = new BufferedInputStream(Files.newInputStream(path));
             InputStreamReader reader = new InputStreamReader(is)) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print(((char) (c)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    //随机访问文件
    public void readWithRandomAccessFile() {
        Path path = Paths.get("data/mmap/readMmapFile.txt");
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(path.toFile(), "r")) {
            for (long i = 0; i < randomAccessFile.length(); i++) {
                randomAccessFile.seek(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void writeFile() throws IOException {
        String str = "沉默王二，《Web全栈开发进阶之路》作者";
        CharBuffer charBuffer = CharBuffer.wrap(str);
        Path path = Paths.get("data/mmap/writeMmapFile.txt");
        try (FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ, StandardOpenOption.WRITE,
                StandardOpenOption.TRUNCATE_EXISTING)) {
            MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 128);
            if (mappedByteBuffer != null) {
                mappedByteBuffer.put(Charset.forName("UTF-8").encode(charBuffer));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
