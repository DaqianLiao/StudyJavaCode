package com.ldq.study.designPattern.create.prototype.classPrototype;

import java.io.Serializable;

/**
 * 附件类，只包含附件名一个成员变量
 */
public class Attachment implements Cloneable {
    private String name;

    public Attachment(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public Attachment clone() {
        Attachment attachment = null;

        try {
            attachment = (Attachment) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return attachment;
    }
}
