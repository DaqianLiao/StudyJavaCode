package com.ldq.study.io.jute;

import org.apache.jute.BinaryInputArchive;
import org.apache.jute.BinaryOutputArchive;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ArrayArchive {
    public static void main(String[] args) throws IOException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BinaryOutputArchive archive = BinaryOutputArchive.getArchive(baos);
        ClientRecord clientRecord = new ClientRecord("name", "alis", 10, 20);
        clientRecord.serialize(archive,"record");
        System.out.println("clientRecord = " + clientRecord);
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        BinaryInputArchive bia = BinaryInputArchive.getArchive(bais);
        ClientRecord clientRecord1 = new ClientRecord();
        clientRecord1.deserialize(bia,"record1");

        System.out.println("clientRecord1 = " + clientRecord1);
    }
}
