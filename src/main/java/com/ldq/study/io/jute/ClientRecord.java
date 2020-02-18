package com.ldq.study.io.jute;

import com.ldq.study.designPattern.action.status.Client;
import org.apache.jute.InputArchive;
import org.apache.jute.OutputArchive;
import org.apache.jute.Record;

import java.io.IOException;

public class ClientRecord implements Record {
    private String name;
    private String alis;
    private int i1;
    private int i2;

    public ClientRecord() {
    }

    public ClientRecord(String name, String alis, int i1, int i2) {
        this.name = name;
        this.alis = alis;
        this.i1 = i1;
        this.i2 = i2;
    }

    @Override
    public void serialize(OutputArchive archive, String tag) throws IOException {
        archive.startRecord(this, tag);
        archive.writeString(name, "name");
        archive.writeString(alis, "alis");
        archive.writeInt(i1, "i1");
        archive.writeInt(i2, "i2");
        archive.endRecord(this, tag);
    }

    @Override
    public void deserialize(InputArchive archive, String tag) throws IOException {
        archive.startRecord(tag);
        this.name = archive.readString("name");
        this.alis = archive.readString("alis");
        this.i1 = archive.readInt("i1");
        this.i2 = archive.readInt("i2");
        archive.endRecord(tag);
    }

    @Override
    public String toString() {
        return "ClientRecord{" +
                "name='" + name + '\'' +
                ", alis='" + alis + '\'' +
                ", i1=" + i1 +
                ", i2=" + i2 +
                '}';
    }
}
