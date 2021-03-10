package com.labuladong.chapter2;

/**
 * @author yangqian
 * @date 2021/3/10
 */
public class Solution538 {

    public static void main(String[] args) {

    }

    private int sum = 0;

    TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.right);
        sum += root.val;
        root.val = sum;
        traverse(root.left);
    }

}
