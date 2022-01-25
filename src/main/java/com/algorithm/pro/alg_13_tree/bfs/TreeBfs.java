package com.algorithm.pro.alg_13_tree.bfs;

import com.algorithm.pro.alg_13_tree.TreeNode;

import java.util.*;

/**
 *
 * BFS 需要借助队列完成操作
 *
 * @author frankq
 * @date 2022/1/24
 */
public class TreeBfs {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();
        if (root == null) {
            return allResults;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        // 将根节点入队列
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            // 每次循环开始的时候，队列中的元素个数其实是当前这一层的节点个数
            int size = nodes.size();
            List<Integer> results = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                // 从队列中取出每一个节点（取出这一层的每个节点）
                TreeNode node = nodes.poll();
                if (Objects.nonNull(node)) {
                    results.add(node.val);
                    // 将该节点的左右子节点入队列
                    if (node.left != null) {
                        nodes.add(node.left);
                    }
                    if (node.right != null) {
                        nodes.add(node.right);
                    }
                }
            }
            allResults.add(results);
        }
        return allResults;
    }

    public static void main(String[] args) {

    }

}
