package com.ldq.study.io.jute;

import org.apache.jute.BinaryInputArchive;
import org.apache.jute.BinaryOutputArchive;

import java.io.*;

public class Archive {
    public static void main(String[] args) throws IOException {

        String path = "archive";
        File file = new File(path);
        OutputStream out = new FileOutputStream(file);
        DataOutputStream os = new DataOutputStream(out);
        BinaryOutputArchive oa = new BinaryOutputArchive(os);
        oa.writeString("name","name");
        oa.writeString("sex" , "sex");
        oa.writeInt(1,"max1");
        oa.writeInt(180,"max180");
        out.close();

        BinaryInputArchive ia = new BinaryInputArchive(new DataInputStream( new FileInputStream(file)));

        String sex = ia.readString("sex");
        String name = ia.readString("name");
        int max180 = ia.readInt("max180");
        int max1 = ia.readInt("max1");
        System.out.println("name = " + name);
        System.out.println("sex = " + sex);
        System.out.println("max180 = " + max180);
        System.out.println("max1 = " + max1);

    }
}
