package com.simple;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author frankq
 * @date 2022/2/14
 */
public class r13_LC239 {

    public static void main(String[] args) {

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int[] res = new int[nums.length - k + 1];
        int r = 0;
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i ++) {
            while (! queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.pollFirst();
            }
            queue.offerLast(i);
            if (i >= k - 1) {
                if (i - queue.peekFirst() >= k) {
                    queue.pollFirst();
                }
                res[r ++] = nums[queue.peekFirst()];
            }
        }
        return res;
    }

}
