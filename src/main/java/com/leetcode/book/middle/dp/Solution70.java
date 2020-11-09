package com.leetcode.book.middle.dp;

/**
 * 动态规划
 * @date 2020/10/13
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class Solution70 {

    public static void main(String[] args) {

    }

    /**
     * 典型的动态规划问题
     * 列式为 dp[n] = dp[n - 1] + dp[n - 2]
     */
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
