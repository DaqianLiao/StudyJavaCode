package com.ldq.study.designPattern.struct.adapter;

/**
 * 适配器类的工厂类：根据不同的类型创建不同目标类，执行目标类的具体方法
 * 实现抽象接口
 */
public class MediaAdapter implements MediaPlayer {

    AdvancedMediaPlay advancedMediaPlay;

    public MediaAdapter(String type) {
        if ("vlc".equalsIgnoreCase(type)) {
            this.advancedMediaPlay = new VlcPlayImpl();
        } else if ("mp4".equalsIgnoreCase(type)) {
            this.advancedMediaPlay = new Mp4PlayImpl();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if ("vlc".equalsIgnoreCase(audioType)) {
            advancedMediaPlay.playVlc(fileName);
        } else if ("mp4".equalsIgnoreCase(audioType)) {
            advancedMediaPlay.playMp4(fileName);
        }
    }
}
