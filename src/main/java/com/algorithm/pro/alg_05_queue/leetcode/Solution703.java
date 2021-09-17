package com.algorithm.pro.alg_05_queue.leetcode;

import java.util.PriorityQueue;

/**
 * 数据流中第k大元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 * @author frankq
 * @date 2021/9/17
 */
public class Solution703 {

    private static class KthLargest {

        int k;
        PriorityQueue<Integer> queue;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            queue = new PriorityQueue<>(k);
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            if (queue.size() < k) {
                queue.offer(val);
            } else if (val > queue.peek()) {
                queue.poll();
                queue.offer(val);
            }
            return queue.peek();
        }

    }

}
