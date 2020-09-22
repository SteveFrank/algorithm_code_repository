package com.leetcode.tree.simpletree;

/**
 * 20200921
 * 538. 把二叉搜索树转换为累加树
 * * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 * @date 2020/9/21
 */
public class Solution538 {

    public static void main(String[] args) {

    }

    int sum = 0;

    /**
     *   2
     * 5  13
     */
    public TreeNode bstToGst(TreeNode root) {
        if (root != null) {
            bstToGst(root.right);
            sum += root.val;
            root.val = sum;
            bstToGst(root.left);
        }
        return root;
    }
}
