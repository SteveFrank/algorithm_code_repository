package com.algorithm.pro.alg_06_code;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 42 接雨水
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * @author frankq
 * @date 2021/9/18
 */
public class Solution42 {

    public static int trap(int[] height) {
        if (height == null) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();

        int max = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                // 使用单调递增处理
                int p = stack.pop();
                if (!stack.isEmpty()) {
                    max += (Math.min(height[stack.peek()], height[i]) - height[p]) * (i - stack.peek() - 1);
                }
            }
            stack.push(i);
        }
        return max;
    }

    public static void main(String[] args) {

    }

}
