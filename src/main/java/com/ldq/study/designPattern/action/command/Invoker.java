package com.ldq.study.designPattern.action.command;

/**
 * 命令调用者：
 * 只负责调用命令
 * 不在乎是什么命令，具体命令有传入决定
 */
public class Invoker {

    public void execute(Cmd cmd) {
        cmd.execute();
    }
}
