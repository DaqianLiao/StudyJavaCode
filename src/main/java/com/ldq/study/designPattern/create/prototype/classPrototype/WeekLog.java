package com.ldq.study.designPattern.create.prototype.classPrototype;

public class WeekLog implements Cloneable {
    private String date;
    private String name;
    private String content;
    private Attachment attachment;

    public WeekLog(String date, String name, String content, Attachment attachment) {
        this.date = date;
        this.name = name;
        this.content = content;
        this.attachment = attachment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    @Override
    public WeekLog clone() {
        WeekLog weekLog = null;
        try {
            weekLog = (WeekLog) super.clone();
            weekLog.attachment = attachment.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return weekLog;
    }

    @Override
    public String toString() {
        return "WeekLog{" +
                "date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", attachment=" + attachment +
                '}';
    }
}
