package com.labuladong.chapter0;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：
 * 给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，每种硬币的数量无限，再给一个总金额 amount，
 * 问你最少需要几枚硬币凑出这个金额，如果不可能凑出，算法返回 -1 。
 *
 * 符合最优子结构，子问题之间相互独立
 *
 * 1、确定base case
 *  >> 这里比较简单，显然目标金额amount=0时候，算法返回0，因为不需要任何硬币就可以凑出目标金额了
 * 2、确定「状态」，也就是原问题和子问题中会变化的变量
 *  >> 由于硬币数量无限，硬币的面额也是题目给定的，只有目标金额会不断地向 base case 靠近，
 *  >> 所以唯一的「状态」就是目标金额 amount。
 * 3、导致「状态」产生变化的行为
 *  >> 目标金额为什么变化呢，因为你在选择硬币，你每选择一枚硬币，就相当于减少了目标金额。
 *  >> 所以说所有硬币的面值，就是你的「选择」。
 * 4、明确 dp 函数/数组的定义
 *
 * @author yangqian
 * @date 2021/3/8
 */
public class LeetCode322 {

    public static void main(String[] args) {

    }

    public int coinChange(int[] coins, int amount) {
//        return dp1(coins, amount);

        Map<Integer, Integer> memo = new HashMap<>();

        return dp2(memo, coins, amount);

    }

    /**
     * 要凑出金额n，至少需要dp(n)个硬币
     * @return
     */
    private int dp1(int[] coins, int n) {
        // 1、base case
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return -1;
        }
        // 2、因为求解最小值，所以初始化为无穷大
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 3、求解子问题
            int subProblem = dp1(coins,n - coin);
            // 子问题是否有解
            if (subProblem == -1) {
                continue;
            }
            res = Math.min(res, 1 + subProblem);
        }
        return res != Integer.MAX_VALUE ? res : -1;
    }

    /**
     * 减少了一部分的消耗
     * @param memo
     * @param coins
     * @param n
     * @return
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



}
