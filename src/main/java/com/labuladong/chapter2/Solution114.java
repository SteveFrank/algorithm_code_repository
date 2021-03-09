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

        flatten(root.left);

        flatten(root.right);

        // 后序遍历位置
        // 1、左右子树拉平成为一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 2、将左子树的节点放到右子树上
        root.left = null;
        root.right = left;

        // 3、循环节点 将原本的右子树放到当前的右子树的节点
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }

}
