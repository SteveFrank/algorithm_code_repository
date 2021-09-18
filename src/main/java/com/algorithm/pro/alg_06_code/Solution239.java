package com.algorithm.pro.alg_06_code;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 239 滑动窗口最大值
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 * @author frankq
 * @date 2021/9/18
 */
public class Solution239 {

    /**
     * 利用单调队列来处理问题
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        // 特殊处理
        if (nums == null || nums.length < k) {
            return new int[]{};
        }
        int[] res = new int[nums.length - k + 1];
        // 构建单调递减队列处理
        int r = 0;
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < nums.length; i ++) {
            // 构建单调递减队列，队列存储的是数组元素的下标
            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            if (i >= k - 1) {
                // 保证后面获取的最大值是在滑动窗口内，只需要用当前下标 - 队列头（最大值） 如果超过窗口大小则将队列头出队列
                if (i - queue.peekFirst() >= k) {
                    queue.pollFirst();
                }
                res[r ++] = nums[queue.peekFirst()];
            }
        }

        return res;
    }

    public static int[] maxSlidingWindow_2(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int max = nums[i];
            if (nums.length >= i + k) {
                for (int j = i; j < i + k; j++) {
                    if (max < nums[j]) {
                        max = nums[j];
                    }
                }
                result[index] = max;
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
