package com.ldq.study.designPattern.action.command;

/**
 * 具体命令
 */
public class OnCmdImpl implements Cmd {
    private Receiver receiver;

    public OnCmdImpl(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.turnOn();
    }
}
