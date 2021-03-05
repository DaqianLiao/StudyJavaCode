package com.ldq.study.algorithm.find.tree;

import lombok.val;

import java.util.ArrayList;
import java.util.Stack;

public class MyAVLTree {
    private AvlNode root;

    private static class AvlNode {
        int element;
        AvlNode left;
        AvlNode right;
        int height;

        public AvlNode(int theElement, AvlNode lt, AvlNode rt) {
            element = theElement;
            left = lt;
            right = rt;
        }
    }

    public int getHeight() {
        return 1;
    }

    private int getHeight(AvlNode t) {
        return t == null ? -1 : t.height;
    }

    private AvlNode insert(Integer x, AvlNode t) {
        if (t == null) {
            return new AvlNode(x, null, null);
        }

        int cmp = x.compareTo(t.element);
        if (cmp < 0) {
            t.left = insert(x, t.left);
            if (getHeight(t.left) - getHeight(t.right) == 2) {
                if (x.compareTo(t.left.element) < 0) {
                    t = rotationSingleLeft(t);
                } else {
                    t = rotationDoubleLeft(t);
                }
            }
        } else if (cmp > 0) {
            t.right = insert(x, t.right);
            if (getHeight(t.right) - getHeight(t.left) == 2) {
                if (x.compareTo(t.right.element) > 0) {
                    t = rotationSingleRight(t);
                } else {
                    t = rotationDoubleRight(t);
                }
            }
        }
        t.height = Math.max(getHeight(t.left), getHeight(t.right)) + 1;
        return t;
    }


    private AvlNode rotationSingleLeft(AvlNode k2) {
        AvlNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(getHeight(k2.left), getHeight(k2.right)) + 1;
        k1.height = Math.max(getHeight(k1.left), k2.height) + 1;
        return k1;
    }

    private AvlNode rotationSingleRight(AvlNode k2) {
        AvlNode k1 = k2.right;
        k2.right = k1.left;
        k1.left = k2;
        k2.height = Math.max(getHeight(k2.right), getHeight(k2.left)) + 1;
        k1.height = Math.max(getHeight(k1.right), k2.height) + 1;
        return k1;
    }

    private AvlNode rotationDoubleLeft(AvlNode k2) {
        k2.left = rotationSingleRight(k2.left);
        return rotationSingleLeft(k2);
    }

    private AvlNode rotationDoubleRight(AvlNode k2) {
        k2.right = rotationSingleLeft(k2.right);
        return rotationSingleRight(k2);
    }

    public void insert(Integer x) {
        root = insert(x, root);
    }

    public void printTree() {
        printTree(root);
    }

    private void printTree(AvlNode t) {
        if (t != null) {
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        }
    }

    public static ArrayList<ArrayList<Integer>> get(AvlNode root) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        get(root, 0, result);

        System.out.println(result);
        return result;
    }

    public static void get(AvlNode root, int level, ArrayList<ArrayList<Integer>> res) {
        System.out.println("node = "+ root.element + ", level = " + level);
        System.out.println("res = " + res);
        System.out.println("res.size = " + res.size());
        if (level == res.size()) {
            res.add(new ArrayList<>());
        }
        System.out.println("res = " + res);
        res.get(level).add(root.element);
        if (root.left != null) {
            get(root.left, level + 1, res);
        }
        if (root.right != null) {
            get(root.right, level + 1, res);
        }
    }

    public static void scan(AvlNode root){
        if (root==null){
            System.out.println("null root");
        }

        Stack<AvlNode> stack =  new Stack<>();

    }

    public static void main(String[] args) {
        MyAVLTree avl = new MyAVLTree();
        avl.insert(50);
        avl.insert(60);
        avl.insert(30);
//        avl.insert(40);
//        avl.insert(45);
//        avl.insert(47);

        avl.printTree();

        val arrayLists = get(avl.root);

    }
}
