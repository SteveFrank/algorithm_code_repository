package com.labuladong.chapter2;

/**
 *
 * 二叉搜索树查找一个节点
 *
 * @author yangqian
 * @date 2021/3/10
 */
public class Solution700 {

    public static void main(String[] args) {

    }

    public TreeNode searchBST(TreeNode root, int val) {
        return traverse(root, val);
    }

    TreeNode traverse(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val > val) {
            return traverse(root.left, val);
        } else if (root.val < val) {
            return traverse(root.right, val);
        }
        return root;
    }



}
