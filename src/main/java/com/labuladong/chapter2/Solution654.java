package com.labuladong.chapter2;

/**
 * @author yangqian
 * @date 2021/3/9
 */
public class Solution654 {

    public static void main(String[] args) {

    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int low, int high) {
        // base case
        if (low > high) {
            return null;
        }
        // 找到数组中的最大值和对应的索引信息
        int index = -1;
        int maxVal = Integer.MIN_VALUE;
        for (int i = low; i <= high; i++) {
            if (maxVal < nums[i]) {
                index = i;
                maxVal = nums[i];
            }
        }

        TreeNode root = new TreeNode(maxVal);

        // 递归构造左子树
        root.left = build(nums, low, index - 1);
        if (index < nums.length) {
            root.right = build(nums, index + 1, high);
        }

        return root;
    }

}
