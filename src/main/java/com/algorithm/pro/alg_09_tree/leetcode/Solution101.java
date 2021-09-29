package com.algorithm.pro.alg_09_tree.leetcode;

/**
 *
 * 101 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 *
 * @author frankq
 * @date 2021/9/27
 */
public class Solution101 {

    static class TreeNode {

        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {}

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        return recur(root.left, root.right);

    }

    public boolean recur(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }

        boolean one = recur(left.left, right.right);
        boolean two = recur(right.left, left.right);

        return one && two;

    }

    public static void main(String[] args) {

    }

}
