package com.ldq.study.designPattern.struct.composite;


import java.util.ArrayList;
import java.util.List;

/**
 * 复合组合对象
 * 内部包含一组抽象组合对象
 */
public class DirNode extends Node {
    private List<Node> nodes = new ArrayList<>();

    public DirNode(String name) {
        super(name);
    }

    public List<Node> getNodes() {
        return nodes;
    }

    @Override
    public void addNode(Node node) throws Exception {

        nodes.add(node);
    }

    @Override
    public void display() {
        System.out.println(name);
        for (Node node : nodes) {
            node.display();
        }
    }
}
