package com.simple;

/**
 * @author frankq
 * @date 2022/2/17
 */
public class r22_LC101 {

    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return recur(root.left, root.right);
    }

    // 一层层判断是否ok
    public boolean recur(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        boolean one = recur(left.left, right.right);
        boolean two = recur(left.right, right.left);
        return one && two;
    }

}
