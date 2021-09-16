package com.algorithm.pro.alg_03_code.leetcode;

import java.util.Arrays;

/**
 * LCP 18 早餐组合
 * https://leetcode-cn.com/problems/2vYnGI/
 * @author frankq
 * @date 2021/9/16
 */
public class SolutionLCP18 {

    /**
     * 排序剪枝的方式
     * 对于两个数组排序后逐步剪枝
     * 时间复杂度 O(m + n) 空间复杂度 O(1)
     */
    public static int breakfastNumber(int[] staple, int[] drinks, int x) {
        // 定义结果集数量
        int count = 0;
        // 对于数组排好序，能利用已排序数组的一些特性
        Arrays.sort(staple);
        Arrays.sort(drinks);
        // 定义双指针
        int p1 = 0;
        int p2 = drinks.length - 1;
        while (p1 < staple.length && p2 >= 0) {
            if (staple[p1] + drinks[p2] <= x) {
                count = (count + p2 + 1) % 1000000007;
                p1 ++;
            } else {
                p2 --;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }

}
