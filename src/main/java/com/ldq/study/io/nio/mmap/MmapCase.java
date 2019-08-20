package com.ldq.study.io.nio.mmap;

import sun.rmi.runtime.Log;

import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MmapCase {
    public static void main(String[] args) throws IOException {
        String fileName = "mmap.txt";
        ClassLoader classLoader = MmapCase.class.getClassLoader();
        Path path = Paths.get(classLoader.getResource(fileName).getPath());
//        FileChannel fileChannel = FileChannel.open(path);
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
            MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
            if (mappedByteBuffer != null) {
                charBuffer = Charset.forName("UTF-8").decode(mappedByteBuffer);
            }
            System.out.println(charBuffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
