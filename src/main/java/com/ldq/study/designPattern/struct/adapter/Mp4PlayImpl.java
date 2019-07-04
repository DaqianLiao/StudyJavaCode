package com.ldq.study.designPattern.struct.adapter;

/**
 * 具体的目标实现类
 */
public class Mp4PlayImpl implements AdvancedMediaPlay {
    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file: " + fileName);
    }

    @Override
    public void playVlc(String fileName) {

    }
}
