package com.ldq.study.designPattern.struct.adapter;

/**
 * 目标类的抽象接口
 */
public interface MediaPlayer {
    void play(String audioType, String fileName);
}
