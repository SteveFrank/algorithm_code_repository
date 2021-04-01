package com.labuladong.chapter0.bfs;

import com.labuladong.chapter2.TreeNode;

import java.util.*;

/**
 * @author yangqian
 * @date 2021/3/26
 */
public class BFSDemo {

    public static void main(String[] args) {

    }

    int bfs(Node start, Node target) {
        // 核心数据结构
        Queue<Node> queue = new LinkedList<>();
        // 走过的路不走回头路
        Set<Node> visited = new HashSet<>();

        // 将起点加入队列
        queue.offer(start);
        // 该节点已经走过
        visited.add(start);
        // 记录已经扩散的部署
        int step = 0;

        while (queue.size() > 0) {
            int size = queue.size();
            // 将当前队列中的所有节点向四周扩散
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                // 判断是否到达了终点
                if (current == target) {
                    return step;
                }
                // 将当前的current相邻节点加入到队列中
//                for (Node node : current.adj()) {
//                    if (x not in visited) {
//                        q.offer(x);
//                        visited.add(x);
//                    }
//                }
            }
            // 更新步数
            step ++;
        }
        return 0;
    }

    int minDepth_1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null || root.right == null) {
            return 1;
        }
        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            minDepth = Math.min(minDepth_1(root.left), minDepth);
        }
        if (root.right != null) {
            minDepth = Math.min(minDepth_1(root.right), minDepth);
        }
        return minDepth + 1;
    }

    /**
     * 该解法是BFS空间复杂度较高
     * DFS的解法空间复杂度较低 O(logN)
     * @param root
     * @return
     */
    int minDepth_2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // root本身就是一层，depth 初始化为 1
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                // 到达了叶子节点
                if (currentNode.left == null && currentNode.right == null) {
                    return depth;
                }
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            // 增加步数
            depth ++;
        }
        return depth;
    }

}

class Node {

}