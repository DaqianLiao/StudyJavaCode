package com.ldq.study.designPattern.struct.adapter;

/**
 * 抽象适配着接口
 */
public interface AdvancedMediaPlay {
    void playMp4(String fileName);

    void playVlc(String fileName);
}
