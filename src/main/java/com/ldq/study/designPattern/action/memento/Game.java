package com.ldq.study.designPattern.action.memento;

/**
 * 具体操作类，提供了将数据写入备忘录/从备忘录读数据的方法
 */
public class Game {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento saveStateToMemento(){
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento){
        state = memento.getState();
    }

    @Override
    public String toString() {
        return "Game{" +
                "state='" + state + '\'' +
                '}';
    }
}
