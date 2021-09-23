package com.algorithm.pro.alg_08_recur.leetcode;

/**
 * @author frankq
 * @date 2021/9/23
 */
public class Solution70 {

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {

    }

}
