package com.labuladong.chapter0;

/**
 * 01.动态规划解题套路框架
 * labuladong algorithm code
 * https://labuladong.gitee.io/algo/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E7%B3%BB%E5%88%97/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E8%AF%A6%E8%A7%A3%E8%BF%9B%E9%98%B6.html
 *
 * @author yangqian
 * @date 2021/3/8
 */
public class LeetCode509 {

    public static void main(String[] args) {
        LeetCode509 leetCode509 = new LeetCode509();
        System.out.println(leetCode509.fib1(2));
    }



    public int fib1(int n) {
        if (n < 1) {
            return 0;
        }
        int[] memo = new int[n + 1];
        return helper(memo, n);
    }

    /**
     * 利用备忘录记录避免递归中的重复计算
     * @param memo 备忘录
     * @param n
     * @return
     */
    private int helper(int[] memo, int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }

    /**
     * dp数组的迭代解法
     * @param n
     * @return
     */
    public int fib2(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
