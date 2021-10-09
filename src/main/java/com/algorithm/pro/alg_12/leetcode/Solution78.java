package com.algorithm.pro.alg_12.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author frankq
 * @date 2021/10/9
 */
public class Solution78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        backtrack(nums, 0, path, res);
        return res;
    }

    public void backtrack(int[] nums, int start, Deque<Integer> path, List<List<Integer>> res) {
        // 每下探一层记录一次中间结果
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.addLast(nums[i]);
            backtrack(nums, i + 1, path, res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {

    }

}
