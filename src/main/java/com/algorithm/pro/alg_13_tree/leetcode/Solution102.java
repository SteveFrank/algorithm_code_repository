package com.algorithm.pro.alg_13_tree.leetcode;

import com.algorithm.pro.alg_13_tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author frankq
 * @date 2022/1/24
 */
public class Solution102 {

    public List<List<Integer>> levelOrder1(TreeNode root) {
        // 基于BFS
        // 特殊判断
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                // 将左右子树节点加入队列
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            res.add(list);
        }
        return res;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    /**
     * @param root
     * @param level 递归的层数
     * @param res   根据层数添加结果到对应的小层数中
     */
    public void dfs(TreeNode root, int level, List<List<Integer>> res) {
        // terminal
        if (root == null) {
            return;
        }
        // 将当前层的集合进行初始化
        int size = res.size();
        if (level > size - 1) {
            // 初始化层的数据
            res.add(new ArrayList<>());
        }
        // 将当前节点加到当前层对应的集合中
        List<Integer> list = res.get(level);
        list.add(root.val);
        // drill down
        dfs(root.left, level + 1, res);
        dfs(root.right, level + 1, res);
    }

    public static void main(String[] args) {

    }

}
