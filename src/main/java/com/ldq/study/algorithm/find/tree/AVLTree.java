package com.ldq.study.algorithm.find.tree;

public class AVLTree {
    //    保存根节点
    private AvlNode<Integer> root;

    private static class AvlNode<Integer> {
        //        当前节点存储的数据
        Integer element;
        //        左节点
        AvlNode<Integer> left;
        //        右节点
        AvlNode<Integer> right;
        //        保存当前节点的高度
        int height;

        public AvlNode(Integer theElement) {
            this(theElement, null, null);
        }

        public AvlNode(Integer theElement, AvlNode<Integer> lt, AvlNode<Integer> rt) {
            element = theElement;
            left = lt;
            right = rt;
        }
    }

    public AVLTree() {
        root = null;
    }

    public void insert(Integer x) {
        root = insert(x, root);
    }

    private int height() {
        return height(root);
    }

    private int height(AvlNode<Integer> t) {
        int height = t == null ? -1 : t.height;
//        if (t != null) {
//            System.out.println(t.element + " node height = " + height);
//        }
        return height;
    }

    //注意递归的使用，要逐步分析！！！
    private AvlNode<Integer> insert(Integer x, AvlNode<Integer> t) {
//        实际上就是先插入进去，然后在来判断是否需要旋转
        if (t == null) {
            return new AvlNode<Integer>(x, null, null);
        }
//        计算传入数据x和当前节点的比较值
        int compareResult = x.compareTo(t.element);
//        插入左子树
        if (compareResult < 0) {
            t.left = insert(x, t.left);
            System.out.println("x = " + x + ", left = " + t.left.element);
            if (height(t.left) - height(t.right) == 2)
//                与左子树的左节点比较，判断是否是左左单旋转
                if (x.compareTo(t.left.element) < 0) {
                    t = rotateWithLeftChild(t);  //左—左单旋转
                } else {
//                    与左子树的右节点进行比较，判断是否左右双旋转
                    t = doubleWithLeftChild(t);  //左—右双旋转
                }
        } else if (compareResult > 0) {
//            插入右子树
            t.right = insert(x, t.right);
            System.out.println("x = " + x + ", right = " + t.right.element);
            if (height(t.right) - height(t.left) == 2)
                if (x.compareTo(t.right.element) > 0)
                    t = rotateWithRightChild(t);  //右—右单旋转
                else
                    t = doubleWithRightChild(t);  //右—左双旋转
        }
//        更新当前节点的高度
        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }

    //    左左单旋转
    private AvlNode<Integer> rotateWithLeftChild(AvlNode<Integer> k2) {
        System.out.println("rotateWithLeftChild node =" + k2.element);
        AvlNode<Integer> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;

        return k1;
    }

    //    右右单旋转
    private AvlNode<Integer> rotateWithRightChild(AvlNode<Integer> k1) {
        System.out.println("rotateWithRightChild node =" + k1.element);
        AvlNode<Integer> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(height(k2.right), k1.height) + 1;

        return k2;
    }

    //    左-右双旋转
    private AvlNode<Integer> doubleWithLeftChild(AvlNode<Integer> k3) {
        System.out.println("doubleWithLeftChild node =" + k3.element);
//        先执行一次右旋
        k3.left = rotateWithRightChild(k3.left);
//        在执行一次左旋
        return rotateWithLeftChild(k3);
    }

    //    右-左双旋转
    private AvlNode<Integer> doubleWithRightChild(AvlNode<Integer> k1) {
        System.out.println("doubleWithRightChild node =" + k1.element);
//        先执行一次左旋
        k1.right = rotateWithLeftChild(k1.right);
//        在执行一次右旋
        return rotateWithRightChild(k1);
    }

    public void printTree() {
        printTree(root);
    }

    //    使用中序遍历打印tree
    private void printTree(AvlNode<Integer> t) {

        if (t != null) {
            printTree(t.left);
            System.out.println("node = " + t.element + ", height = " + t.height);
            printTree(t.right);
        }

    }

    public static void main(String[] args) {

        AVLTree avl = new AVLTree();
//        avl.insert(50);
//        avl.insert(60);
//        avl.insert(30);
//        avl.insert(40);
//        avl.insert(45);
//        avl.insert(47);

        avl.insert(60);
        avl.insert(20);
        avl.insert(30);

        avl.printTree();

        System.out.println("tree height = " + avl.height());

    }

}