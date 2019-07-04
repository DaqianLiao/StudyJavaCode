package com.ldq.study.designPattern.struct.adapter;

/**
 * 个性化的适配器的实现类：
 * 提供了更多的适配功能，并会对适配器的类型做控制，是否返回具体的适配器
 */
public class AudioPlay implements MediaPlayer {
    MediaAdapter mediaAdapter;


    @Override
    public void play(String audioType, String fileName) {
        if ("mp3".equalsIgnoreCase(audioType)) {
            System.out.println("默认支持播放mp3文件：" + fileName);
        } else if ("mp4".equalsIgnoreCase(audioType) || "vlc".equalsIgnoreCase(audioType)) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media! " + audioType + " format not supported");
        }
    }
}
