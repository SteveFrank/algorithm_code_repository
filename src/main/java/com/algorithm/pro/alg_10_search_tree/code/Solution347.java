package com.algorithm.pro.alg_10_search_tree.code;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347 前K个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 * @author frankq
 * @date 2021/10/3
 */
public class Solution347 {

    public int[] topKFrequent(int[] nums, int k) {
        // 定义has用于统计元素以及其出现的频率
        Map<Integer, Integer> hash = new HashMap<>();
        for (int num : nums) {
            // hash.put (num, hash.getOrDefault(num, 0) + 1)
            if (hash.containsKey(num)) {
                hash.put(num, hash.get(num) + 1);
            } else {
                hash.put(num, 1);
            }
        }

        // 构造优先级队列
        PriorityQueue<Integer> queue = new PriorityQueue(k, Comparator.comparingInt(hash::get));

        for (Integer key : hash.keySet()) {
            if (queue.size() < k) {
                queue.offer(key);
            } else {
                if (hash.get(key) > hash.get(queue.peek())) {
                    queue.poll();
                    queue.offer(key);
                }
            }
        }

        int[] res = new int[k];
        int idx = k - 1;
        while (idx >= 0) {
            res[idx--] = queue.poll();
        }
        return res;
    }

    public static void main(String[] args) {

    }

}
