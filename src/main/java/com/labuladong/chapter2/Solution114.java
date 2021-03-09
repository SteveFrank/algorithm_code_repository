package com.labuladong.chapter2;

/**
 * @author yangqian
 * @date 2021/3/8
 */
public class Solution114 {

    public static void main(String[] args) {

    }

    public void flatten(TreeNode root) {
        // base case
        if (root == null) {
            return;
        }

        // 先处理左子树
        flatten(root.left);
        // 再处理右子树
        flatten(root.right);

        // 后续遍历
        TreeNode right = root.right;
        TreeNode left = root.left;

        // 将左子树的节点移到右子树
        root.left = null;
        root.right = left;

        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;

    }

}
