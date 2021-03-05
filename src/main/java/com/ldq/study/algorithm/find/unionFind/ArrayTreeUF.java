package com.ldq.study.algorithm.find.unionFind;

/**
 * 数组模拟树，实现并查集。数组内的元素表示父亲的下角表，相当于指针。
 *
 * union函数，没有采取合理的手段去进行合并。
 * 每次都以secondElement为主，每次合并两个集合都让secondElement的根来继续充当合并之后的根。这样很可能达到线性的链表的状态。
 */
public class ArrayTreeUF {
    private int[] parent;
    private int size;

//    初始化UF： a[0] = 0;a[1] = 1;a[2] = 2;
    public ArrayTreeUF(int size) {
        this.size = size;
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }


    public int find(int element) {
        while (element != parent[element]) {
            element = parent[element];
        }
        return element;
    }

    public boolean isConnected(int firstElement, int secondElement) {
        return find(firstElement) == find(secondElement);
    }

    public void unionElements(int firstElement, int secondElement) {
        int firstRoot = find(firstElement);
        int secondRoot = find(secondElement);
        if (firstRoot == secondRoot) {
            return;
        }
        parent[firstRoot] = secondRoot;
    }

    /**
     * 本并查集使用数组实现，为了更直观地看清内部数据，采用打印数组
     */
    private void printArr() {
        for (int parent : this.parent) {
            System.out.print(parent + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 10;
        ArrayTreeUF union = new ArrayTreeUF(n);
        System.out.println("初始：");
        union.printArr();

        System.out.println("连接了5 6");
        union.unionElements(5, 6);
        union.printArr();

        System.out.println("连接了1 2");
        union.unionElements(1, 2);
        union.printArr();

        System.out.println("连接了2 3");
        union.unionElements(2, 3);
        union.printArr();

        System.out.println("连接了1 4");
        union.unionElements(1, 4);
        union.printArr();

        System.out.println("连接了1 5");
        union.unionElements(1, 5);
        union.printArr();

        System.out.println("1  6 是否连接：" + union.isConnected(1, 6));

        System.out.println("1  8 是否连接：" + union.isConnected(1, 8));
    }
}
