package com.ldq.study.algorithm.find.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeFirstSearch {


    /**
     * 初始化树数据
     *
     * @return
     */
    public static TreeNode initData() {
        TreeNode tn10 = new TreeNode(10, null, null);
        TreeNode tn9 = new TreeNode(9, tn10, null);
        TreeNode tn8 = new TreeNode(8, null, null);
        TreeNode tn7 = new TreeNode(7, null, null);
        TreeNode tn6 = new TreeNode(6, tn8, tn9);
        TreeNode tn5 = new TreeNode(5, null, null);
        TreeNode tn4 = new TreeNode(4, null, null);
        TreeNode tn3 = new TreeNode(3, tn6, tn7);
        TreeNode tn2 = new TreeNode(2, tn4, tn5);
        TreeNode tn1 = new TreeNode(1, tn2, tn3);
        return tn1;
    }

    private static void depthTraversal(TreeNode tn) {
        if (tn != null) {
            depthTraversal(tn.left);
            depthTraversal(tn.right);
            System.out.print(tn.val + "  ");
        }
    }

    /**
     * 深度优先搜索 英文缩写为DFS即Depth First Search
     * 每一个可能的分支路径深入到不能再深入为止，而且每个节点只能访问一次
     * 其中根据根节点输出的位置氛围
     * 前序（根左右），中序（左根右），后序（左右根）
     *
     * @param root
     * @return
     */
    private static ArrayList<Integer> dfs(TreeNode root) {
        ArrayList<Integer> lists = new ArrayList<>();
        if (root == null)
            return lists;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tree = stack.pop();
//　　　　　　先往栈中压入右节点，再压左节点，这样出栈就是先左节点后右节点了。
            if (tree.right != null)
                stack.push(tree.right);
            if (tree.left != null)
                stack.push(tree.left);
            lists.add(tree.val);
        }
        System.out.println(lists);
        return lists;
    }


    /**
     * 广度优先遍历 英文缩写为BFS即Breadth First Search
     * 从根节点遍历，逐层扫描节点数据
     * 从上到下，从左到右
     * 使用队列作为中间存储，利用队列的先进先出特性
     *
     * @param root
     * @return
     */
    public static ArrayList<Integer> bfs(TreeNode root) {
        ArrayList<Integer> lists = new ArrayList<>();
        if (root == null)
            return lists;
        Queue<TreeNode> queue = new LinkedList<>();
//        将跟节点加入到队列，返回添加是否成功
        queue.offer(root);
        while (!queue.isEmpty()) {
            //返回获取到的值，如果没有，返回null
            TreeNode tree = queue.poll();
            if (tree.left != null)
                queue.offer(tree.left);
            if (tree.right != null)
                queue.offer(tree.right);
            lists.add(tree.val);
        }

        System.out.println(lists);
        return lists;
    }


    public static void main(String[] args) {
        TreeNode treeNode = initData();
//        bfs(treeNode);
//        dfs(treeNode);
        depthTraversal(treeNode);
    }

}
