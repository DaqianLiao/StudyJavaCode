package com.ldq.study.designPattern.struct.composite;

import java.io.File;

/**
 * 组合模式：将对象组合成树的结构
 * 核心： 简单对象和复合对象都继承同一个抽象复合类
 * 场景：表达对象的层级结构的时候
 *
 */
public class Client {

    /**
     * 递归创建树状目录层级结构
     * @param node
     * @throws Exception
     */
    public static void createTree(DirNode node ) throws Exception {
        File file = new File(node.name);
        File[] files = file.listFiles();
        for (File file1 : files) {

            if (file1.isDirectory()) {
                DirNode innerNode = new DirNode(file1.getPath());
                node.addNode(innerNode);
                createTree(innerNode);
            }
            if(file1.isFile()){
                FileNode fileNode = new FileNode(file1.getPath());
                node.addNode(fileNode);
            }
        }
    }

    public static void main(String[] args) {
        DirNode node = new DirNode("/Users/diligent_leo/Code/StudyJavaCode/src/main/java/com/ldq/study/designPattern/struct");
        try {
            createTree(node);
        } catch (Exception e) {
            e.printStackTrace();
        }

        node.display();
    }
}
