package com.ldq.study.designPattern.action.status;

public class Context {
    private State state;

    public Context() {
    }

    public Context(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
