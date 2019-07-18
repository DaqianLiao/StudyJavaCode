package com.ldq.study.designPattern.action.command;

/**
 * 命令接受者负责具体的命令操作
 */
public class Receiver {
    public void turnOn() {
        System.out.println("receiver turn on!");
    }

    public void turnOff() {
        System.out.println("receiver turn off!");
    }
}
