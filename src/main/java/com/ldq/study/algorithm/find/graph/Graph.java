package com.ldq.study.algorithm.find.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 */
public class Graph {
    private ArrayList vertexList;//存储点的链表
    private int[][] edges;//邻接矩阵，用来存储边
    private int numOfEdges;//边的数目
    boolean[] isVisited;

    public Graph(int n) {
        //初始化矩阵，一维数组，和边的数目
        edges = new int[n][n];
        vertexList = new ArrayList(n);
        numOfEdges = 0;
        isVisited = new boolean[getNumOfVertex()];
    }

    //得到结点的个数
    public int getNumOfVertex() {
        return vertexList.size();
    }

    //得到边的数目
    public int getNumOfEdges() {
        return numOfEdges;
    }

    //返回结点i的数据
    public Object getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //返回v1,v2的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    //插入结点
    public void insertVertex(Object vertex) {
//        vertexList.add(vertexList.size(),vertex);
        vertexList.add(vertex);
    }

    //插入结点
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        numOfEdges++;
    }

    //删除结点
    public void deleteEdge(int v1, int v2) {
        edges[v1][v2] = 0;
        numOfEdges--;
    }

    //得到第一个邻接结点的下标
    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //根据前一个邻接结点的下标来取得下一个邻接结点
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //私有函数，深度优先遍历
    private void depthFirstSearch(boolean[] isVisited, int i) {
        //首先访问该结点，在控制台打印出来
        System.out.print(getValueByIndex(i) + "  ");
        //置该结点为已访问
        isVisited[i] = true;

        int w = getFirstNeighbor(i);//
        while (w != -1) {
            if (!isVisited[w]) {
                depthFirstSearch(isVisited, w);
            }
            w = getNextNeighbor(i, w);
        }
    }

    //对外公开函数，深度优先遍历，与其同名私有函数属于方法重载
    public void depthFirstSearch() {
        for (int i = 0; i < getNumOfVertex(); i++) {
            //因为对于非连通图来说，并不是通过一个结点就一定可以遍历所有结点的。
            if (!isVisited[i]) {
                depthFirstSearch(isVisited, i);
            }
        }
    }

    //私有函数，广度优先遍历

    /**
     * 访问初始结点v并标记结点v为已访问。
     * 结点v入队列
     * 当队列非空时，继续执行，否则算法结束。
     * 出队列，取得队头结点u。
     * 查找结点u的第一个邻接结点w。
     * 若结点u的邻接结点w不存在，则转到步骤3；否则循环执行以下三个步骤：
     * 1). 若结点w尚未被访问，则访问结点w并标记为已访问。
     * 2). 结点w入队列
     * 3). 查找结点u的继w邻接结点后的下一个邻接结点w，转到步骤6。
     */
    private void broadFirstSearch(boolean[] isVisited, int i) {
        int u, w;
        LinkedList queue = new LinkedList();

        //访问结点i
        System.out.print(getValueByIndex(i) + "  ");
        isVisited[i] = true;
        //结点入队列
        queue.addLast(i);
        while (!queue.isEmpty()) {
            u = ((Integer) queue.removeFirst()).intValue();
            w = getFirstNeighbor(u);
            while (w != -1) {
                if (!isVisited[w]) {
                    //访问该结点
                    System.out.print(getValueByIndex(w) + "  ");
                    //标记已被访问
                    isVisited[w] = true;
                    //入队列
                    queue.addLast(w);
                }
                //寻找下一个邻接结点
                w = getNextNeighbor(u, w);
            }
        }
    }

    //对外公开函数，广度优先遍历
    public void broadFirstSearch() {
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                broadFirstSearch(isVisited, i);
            }
        }
    }

    @Override
    public String toString() {
        return "Graph{" +
                "vertexList=" + vertexList +
                ", edges=" + Arrays.toString(edges) +
                ", numOfEdges=" + numOfEdges +
                ", isVisited=" + Arrays.toString(isVisited) +
                '}';
    }
}
