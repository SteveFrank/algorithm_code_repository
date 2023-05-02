package com.vip.leetcode.dynamic;

import java.util.Arrays;

/**
 * @author frankq
 * @date 2023/5/2
 */
public class LeetCode300 {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        // base case : dp数组全部初始化为 1
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i;  j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {

    }

}
