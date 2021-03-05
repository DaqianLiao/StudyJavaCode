package com.ldq.study.spi;

import java.util.ServiceLoader;

public class SpiMain {
    public static void main(String[] args) {
        ServiceLoader<Upload> loads = ServiceLoader.load(Upload.class);
        for (Upload load : loads) {
            load.upload();
        }
    }
}
