package com.simple;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author frankq
 * @date 2022/2/11
 */
public class r06_LC239 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] res = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        // 特殊处理
        if (nums == null || nums.length < k) {
            return new int[]{};
        }
        int[] res = new int[nums.length - k + 1];
        // 构建单调递减队列处理
        int r = 0;
        // 单调队列存储数组的下标
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            // 构建单调递减的队列，队列存储的是数组的下标元素
            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                // 拉出最后一个
                queue.pollLast();
            }
            queue.offerLast(i);
            if (i >= k - 1) {
                // 保证获取到的最大值必须在滑动窗口里面
                if (i - queue.peekFirst() >= k) {
                    // 拉出第一个
                    queue.pollFirst();
                }
                res[r++] = nums[queue.peekFirst()];
            }
        }
        return res;
    }

}
