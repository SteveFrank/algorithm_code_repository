package com.simple;

/**
 * @author frankq
 * @date 2022/2/17
 */
public class r19_LC104 {

    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLength = dfs(root.left);
        int rightLength = dfs(root.right);
        return Math.max(leftLength, rightLength) + 1;
    }

}
