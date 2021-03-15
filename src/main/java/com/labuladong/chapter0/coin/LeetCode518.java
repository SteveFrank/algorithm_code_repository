package com.labuladong.chapter0.coin;

/**
 *
 * 凑零钱问题，有多少种解法
 *
 * @author yangqian
 * @date 2021/3/15
 */
public class LeetCode518 {

    public static void main(String[] args) {
        LeetCode518 leetCode518 = new LeetCode518();
        leetCode518.change(5, new int[]{1, 2, 3});
    }

    // 动态规划，dp拉平
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int x = coin; x < amount + 1; ++x) {
                dp[x] += dp[x - coin];
            }
        }

        return dp[amount];
    }

}
