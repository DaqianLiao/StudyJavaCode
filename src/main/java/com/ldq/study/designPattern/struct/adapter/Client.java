package com.ldq.study.designPattern.struct.adapter;

/**
 * 适配器模式的优缺点：
 * 优点：
 * 1/解耦目标类和适配者类，通过引用一个适配器来崇勇现有的适配者类
 * 2/扩展性和灵活性好，符合开闭原则
 * 3/增加类的透明性，可以将具体的业务实现过程封装在适配着类中
 * 缺点：
 * 1/java不支持多继承，也就是一次只能适配一个适配着类，不能适配多个适配着
 * 2/适配着类不能被final修饰
 *
 *
 */
public class Client {
    public static void main(String[] args) {
        AudioPlay audioPlay = new AudioPlay();
        audioPlay.play("mp3", "beyond.mp3");
        audioPlay.play("mp4", "快乐星球.mp4");
        audioPlay.play("vlc", "far far away.vlc");
        audioPlay.play("avi", "japan.avi");
    }
}
