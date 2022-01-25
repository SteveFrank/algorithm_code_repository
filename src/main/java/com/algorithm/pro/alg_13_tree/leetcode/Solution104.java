package com.algorithm.pro.alg_13_tree.leetcode;

import com.algorithm.pro.alg_13_tree.TreeNode;

/**
 * @author frankq
 * @date 2022/1/25
 */
public class Solution104 {

    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    /**
     * 求一棵子树的最大深度
     */
    public int dfs(TreeNode node) {
        // 终止条件
        if (node == null) {
            return 0;
        }
        // 左子树的最大深度
        int leftLength = dfs(node.left);
        int rightLength = dfs(node.right);
        return Math.max(leftLength, rightLength) + 1;
    }

    public static void main(String[] args) {

    }

}
