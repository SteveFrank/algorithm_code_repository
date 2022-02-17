package com.simple;

/**
 * 判断二叉树是否为一棵平衡二叉树
 *
 * @author frankq
 * @date 2022/2/17
 */
public class r21_LC110 {

    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {
        // 左子树的最高高度 和 右子树相比是否小于等于1
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1
                    && isBalanced(root.left)
                    && isBalanced(root.right);
        }
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }

}
