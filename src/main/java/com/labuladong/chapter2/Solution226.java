package com.labuladong.chapter2;

/**
 * @author yangqian
 * @date 2021/3/8
 */
public class Solution226 {

    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        // base case
        if (root == null) {
            return null;
        }

        // 前序遍历 （从root节点开始）
        // 后序遍历也OK
        // root节点开始交换左右节点
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        // 让左右子节点继续反转他们的子节点
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

}
