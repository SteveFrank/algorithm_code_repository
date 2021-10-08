package com.algorithm.pro.alg_12.leetcode;

/**
 * leetcode50 Pow(x, n)
 * https://leetcode-cn.com/problems/powx-n/
 * @author frankq
 * @date 2021/10/8
 */
public class Solution50 {

    /**
     * 分治的思想
     */
    public double myPow(double x, int n) {
        if (n < 0) {
            return 1 / recurPow(x, -n);
        } else {
            return recurPow(x, n);
        }
    }

    public double recurPow(double x, int n) {
        // 终止：最小的子问题
        if (n == 0) {
            return 1.0;
        }
        if (n == 1) {
            return x;
        }
        // 处理当前层的逻辑，下探到下一层
        double subRes = recurPow(x, n / 2);
        // 合并子问题
        if (n % 2 == 0) {
            return subRes * subRes;
        } else {
            return subRes * subRes * x;
        }
    }

    public static void main(String[] args) {

    }

}
