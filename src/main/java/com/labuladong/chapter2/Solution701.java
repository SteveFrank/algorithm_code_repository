package com.labuladong.chapter2;

/**
 *
 * 在BST中插入一个节点
 *
 * @author yangqian
 * @date 2021/3/10
 */
public class Solution701 {

    public static void main(String[] args) {

    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        // base case
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        } else if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }

}
