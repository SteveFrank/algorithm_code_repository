package com.algorithm.pro.alg_12.leetcode;

/**
 * Leetcode236 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * @author frankq
 * @date 2021/10/8
 */
public class Solution236 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        // 分别在左右子树找寻最近的父节点
        TreeNode leftp = lowestCommonAncestor(root.left, p, q);
        TreeNode rightp = lowestCommonAncestor(root.right, p, q);
        // 左子树中没有最近公共父节点
        if (leftp == null) {
            return rightp;
        }
        if (rightp == null) {
            return leftp;
        }
        return root;
    }

    public static void main(String[] args) {

    }

}
