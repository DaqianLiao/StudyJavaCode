package com.ldq.study.designPattern.struct.composite;

/**
 * 定义文件节点，简单组合对象
 */
public class FileNode extends Node {
    public FileNode(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println(name);
    }
}
