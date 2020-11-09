package com.leetcode.book.middle.array;

/**
 * @author yangqian
 * @date 2020/9/30
 */
public class Solution02 {

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        return calculate(prices, 0);
    }

    public int calculate(int prices[], int s) {
        if (s > prices.length) {
            return 0;
        }
        int max = 0;
        for (int start = s; start < prices.length; start ++) {
            int maxProfit = 0;
            for (int i = start + 1; i < prices.length; i ++) {
                if (prices[i] > prices[start]) {
                    int profit = calculate(prices, i + 1) + prices[i] - prices[start];
                    if (profit > maxProfit) {
                        maxProfit = profit;
                    }
                }
            }
            if (maxProfit > max) {
                max = maxProfit;
            }
        }
        return max;
    }

}
