package com.ldq.study.designPattern.action.status;

public class StartStateImpl implements State {
    @Override
    public void doAction(Context context) {
        context.setState(this);
        System.out.println("Player is in start State! " + this.getClass().getName());
    }
}
