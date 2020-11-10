package com.leetcode.book.primary.tree;

/**
 * @author yangqian
 * @date 2020/11/10
 */
public class Solution104 {

    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

}
