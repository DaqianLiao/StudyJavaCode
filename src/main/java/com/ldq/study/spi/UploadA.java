package com.ldq.study.spi;

public class UploadA implements Upload {
    @Override
    public void upload() {
        System.out.println("this class is "+ this.getClass().getName());
    }
}
