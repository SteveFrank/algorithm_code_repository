package com.leetcode.tree.simpletree;

/**
 * 20200818
 * 111. 二叉树的最小深度
 * * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * @date 2020/8/21
 */
public class Solution111 {

    public static void main(String[] args) {
        
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            minDepth = Math.min(minDepth(root.left), minDepth);
        }
        if (root.right != null) {
            minDepth = Math.min(minDepth(root.right), minDepth);
        }
        return minDepth + 1;
    }

}
