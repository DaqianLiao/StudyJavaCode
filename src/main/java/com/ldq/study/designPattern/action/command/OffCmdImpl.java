package com.ldq.study.designPattern.action.command;

public class OffCmdImpl implements Cmd {
    private Receiver receiver;

    public OffCmdImpl(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.turnOff();
    }
}
