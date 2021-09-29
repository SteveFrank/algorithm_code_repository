package com.algorithm.pro.alg_09_tree.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * 完成二叉树的前序遍历
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 *
 * @author frankq
 * @date 2021/9/27
 */
public class Solution144 {

    static class TreeNode {

        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {}

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        recur(root, res);
        return res;
    }

    /**
     * 使用递归的方式完成二叉树的前序遍历
     */
    public void recur(TreeNode node, List<Integer> res) {
        // terminal 终止条件
        if (node == null) {
            return;
        }
        // process current logic
        res.add(node.val);
        // 下探到下一层
        recur(node.left, res);
        recur(node.right, res);
    }

    public static void main(String[] args) {

    }

}
