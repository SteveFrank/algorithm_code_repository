package com.algorithm.pro.alg_14_greedy;

import java.util.Arrays;

/**
 * @author frankq
 * @date 2022/1/26
 */
public class Solution322_2 {

    public int coinChange(int[] coins, int amount) {
        // 从大到小排列
        sort(coins);
        dfs(coins, amount, 0, 0);
        if (minCount == Integer.MAX_VALUE) {
            return -1;
        }
        return minCount;
    }

    public void sort(int[] coins) {
        // 为了方便操作先 Arrays.sort 然后倒置
        Arrays.sort(coins);
        int n = coins.length - 1;
        int temp;
        for (int i = 0; i <= (n - 1) / 2; i++) {
            temp = coins[i];
            coins[i] = coins[n - i];
            coins[n - i] = temp;
        }
    }

    // 全局最优解使用的是最少的硬币数量
    int minCount = Integer.MAX_VALUE;

    /**
     *
     * @param coins         硬币数组
     * @param amount        金额
     * @param selectedCount 选择总数
     * @param startIndex    开始index
     */
    public void dfs(int[] coins, int amount, int selectedCount, int startIndex) {
        // 如果 amount == 0 则终止
        if (amount == 0) {
            if (selectedCount < minCount) {
                minCount = selectedCount;
            }
            return;
        }
        if (startIndex >= coins.length) {
            return;
        }

        // 计算当前硬币最多能使用多少次
        int maxCount = amount / coins[startIndex];
        // 从选择列表[0, maxCount]中选择，然后到下一个硬币
        for (int i = maxCount; i >= 0 && i + selectedCount < minCount; i--) {
            // 选择i个该硬币后剩余的额度
            int resAmount = amount - i * coins[startIndex];
            // drill down
            dfs(coins, resAmount, selectedCount + i, startIndex + 1);
        }
    }

}
