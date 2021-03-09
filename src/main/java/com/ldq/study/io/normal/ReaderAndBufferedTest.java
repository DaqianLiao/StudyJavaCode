package com.ldq.study.io.normal;

import java.io.*;

public class ReaderAndBufferedTest {
    public static void main(String[] args){
        try{
            File fileDir=new File("data/io");
            System.out.println(fileDir.mkdirs());
            File file=new File(fileDir,"android.txt");

            FileReader in=new FileReader("data/io/demo.txt");

            FileWriter out=new FileWriter(file);
            BufferedReader br=new BufferedReader(in);
            BufferedWriter bw=new BufferedWriter(out);

            int b;
            System.out.println("下面读取文件");
            while((b=br.read())!=-1){
                System.out.print((char)b);
                bw.write(b);
            }
//            主要是将缓冲区的数据强制刷新到目标磁盘
            bw.flush();//务必写
            in.close();//勿写br.close()和bw.close()
            out.close();


        }catch(FileNotFoundException e){
            System.out.println("/n找不到文件");
            System.exit(-1);
        }catch(IOException e){
            e.printStackTrace();
            System.exit(-1);
        }
        System.out.println("/n文件已复制");
    }

    public static void read() throws FileNotFoundException {
        File fileDir=new File("data/io");
        System.out.println(fileDir.mkdirs());
        FileReader in=new FileReader("data/io/demo.txt");

        BufferedReader br=new BufferedReader(in);


    }
}
