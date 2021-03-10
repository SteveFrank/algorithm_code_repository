package com.labuladong.chapter2;

/**
 *
 * 验证二叉搜索树
 *
 * @author yangqian
 * @date 2021/3/10
 */
public class Solution98 {

    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, TreeNode max, TreeNode min) {
        // base case
        if (root == null) {
            return true;
        }
        // 选择
        if (max != null && root.val >= max.val) {
            return false;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        return isValidBST(root.left, root, min) && isValidBST(root.right, max, root);
    }


}
