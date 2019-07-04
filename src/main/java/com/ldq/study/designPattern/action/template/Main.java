package com.ldq.study.designPattern.action.template;

public class Main {
    public static void main(String[] args) {
        Game game = new FootballGameImpl();
        game.play();
    }
}
