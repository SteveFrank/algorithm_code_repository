package com.algorithm.pro.array.leetcode;

/**
 * LeetCode
 * https://leetcode-cn.com/problems/container-with-most-water/
 * @author frankq
 * @date 2021/9/14
 */
public class Solution11 {

    /**
     * 算法思想：双指针思想
     * 复杂度：O(n)
     * 解法：使用双指针的解法
     */
    public static int maxArea(int[] height) {
        // 定义最大的水的值
        int res = 0;
        // 定义双指针
        int i = 0;
        int j = height.length - 1;
        while (i != j) {
            // 夹逼面积的方法
            int rest = Math.min(height[i], height[j]) * (j - i);
            if (height[i] < height[j]) {
                i ++;
            } else {
                j --;
            }
            res = Math.max(res, rest);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

}
