package com.algorithm.pro.alg_09_tree.leetcode;

/**
 *
 * 226 翻转二叉树
 * https://leetcode-cn.com/problems/invert-binary-tree/
 *
 * @author frankq
 * @date 2021/9/27
 */
public class Solution226 {

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

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.right;
        root.right = temp.left;
        temp.left = root;

        invertTree(root.left);
        invertTree(root.right);

        return root;

    }

    public static void main(String[] args) {

    }

}
