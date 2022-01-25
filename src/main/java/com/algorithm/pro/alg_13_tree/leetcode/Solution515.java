package com.algorithm.pro.alg_13_tree.leetcode;

import com.algorithm.pro.alg_13_tree.TreeNode;

import java.util.*;

/**
 * @author frankq
 * @date 2022/1/25
 */
public class Solution515 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (Objects.nonNull(node)) {
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                    max=Math.max(max, node.val);
                }
            }
            res.add(max);
        }
        return res;
    }

    public static void main(String[] args) {

    }

}
