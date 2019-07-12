package com.ldq.study.designPattern.struct.composite;

/**
 * 抽象类
 *
 */
public abstract class Node {

    protected String name;

    public Node(String name) {
        this.name = name;
    }

    public void addNode(Node node) throws Exception{
        throw new Exception("Invalid exceotion");
    }

    public abstract void display();
}
