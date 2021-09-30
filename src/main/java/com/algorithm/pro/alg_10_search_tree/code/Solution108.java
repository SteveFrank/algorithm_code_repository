package com.algorithm.pro.alg_10_search_tree.code;

/**
 * 将有序数组转换为二叉搜索树
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * @author frankq
 * @date 2021/9/30
 */
public class Solution108 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return recur(nums, 0, nums.length - 1);
    }

    public TreeNode recur(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        // 找到中间的节点
        int mid = (end - start) / 2 + start;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = recur(nums, start, mid - 1);
        root.right = recur(nums, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {

    }

}
