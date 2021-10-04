package com.algorithm.pro.alg_10_search_tree.code;

import java.util.PriorityQueue;

/**
 * 40 最小的k个数
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * @author frankq
 * @date 2021/10/3
 */
public class Solution40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(arr.length);
        // 将所有元素入队列
        for (int r : arr) {
            queue.offer(r);
        }
        // 依次从堆顶取出元素
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    public static void main(String[] args) {

    }

}
