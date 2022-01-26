package com.algorithm.pro.alg_14_greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author frankq
 * @date 2022/1/26
 */
public class Solution322_1 {

    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> memo = new HashMap<>();
        return dp2(memo, coins, amount);
    }

    /**
     * @param memo  备忘录
     * @param coins 硬币集合
     * @param n     还剩下多少钱
     */
    private int dp2(Map<Integer, Integer> memo, int[] coins, int n) {
        // 1、查找备忘录中的数据，避免重复的计算
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        // 2、base case
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return -1;
        }
        // 3、结果计算
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = dp2(memo, coins, n - coin);
            if (subProblem == -1) {
                continue;
            }
            res = Math.min(res, 1 + subProblem);
        }
        // 将结果部分计入备忘录
        memo.put(n, res != Integer.MAX_VALUE ? res : -1);
        return memo.get(n);
    }

    public static void main(String[] args) {

    }

}
