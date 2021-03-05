package com.ldq.study.algorithm.leetcode;

public class ListReserver {

    static class Node {
        public int value;
        public Node next;

        @Override
        public String toString(){
            return " node value = " + value;
        }
    }

    public static Node demo(){
        Node one = new Node();
        one.value = 1;
        Node two = new Node();
        two.value = 2;
        one.next = two;
        Node three = new Node();
        three.value = 3;
        two.next = three;
        Node four = new Node();
        four.value = 4;
        three.next = four;
        return one;
    }

    public static Node reverseList(Node head){
        if (head == null || head.next == null) return head;
        // 从下一个节点开始递归
        System.out.println("head -> " + head);
//         找到最后一个节点，直接返回最后一个节点，head.next=null,那么head肯定是最后一个节点
        Node reverse = reverseList(head.next);
        System.out.println("deal with head node = " + head);
        printNode(head);
        head.next.next = head; // 设置下一个节点的 next 为当前节点
        head.next = null; // 把当前节点的 next 赋值为 null，避免循环引用
        printNode(head);
        System.out.println("reverse -> " + reverse);
        return reverse;
    }

    public static void printNode(Node head){
        System.out.println("-------------------");
        Node temp =  head;
        while(temp != null ){
            System.out.println("temp -> " + temp);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
       Node first = demo();

       printNode(first);
        Node node = reverseList(first);
        printNode(node);
    }
}
