package com.ldq.study.designPattern.struct.adapter;

/**
 * 具体的目标实现类
 */
public class VlcPlayImpl implements AdvancedMediaPlay {

    @Override
    public void playMp4(String fileName) {
    }

    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file: " + fileName);
    }
}
