package com.ldq.study.designPattern.action.memento;

/**
 * 通过将状态持久化到外部，提供回滚功能
 */
public class Client {
    public static void main(String[] args) {
        CareTaker taker = new CareTaker();
        Game game = new Game();
        game.setState("state1");
        game.setState("state2");
        game.setState("state3");
        taker.addMemento(game.saveStateToMemento());
        game.setState("state4");
        game.setState("state5");
        taker.addMemento(game.saveStateToMemento());
        game.setState("state6");
        game.setState("state7");
        game.setState("state8");
        taker.addMemento(game.saveStateToMemento());
        System.out.println(game);
        game.setState(taker.getMemento(1).getState());
        System.out.println(game);
    }
}
