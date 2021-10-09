package com.algorithm.pro.alg_12.leetcode;

import java.util.*;

/**
 * leetcode 47 全排列II
 * https://leetcode-cn.com/problems/permutations-ii/
 * @author frankq
 * @date 2021/10/9
 */
public class Solution47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Deque<Integer> path = new ArrayDeque<>();
        // 对nums排序，为剪枝2的前提
        Arrays.sort(nums);
        backtrack(nums, 1, path, used, res);
        return res;
    }

    public void backtrack(int[] nums, int dept, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        // terminal 终止条件
        if (dept > nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 剪枝 1
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                // 剪枝 2
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;

            backtrack(nums, dept + 1, path, used, res);

            path.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {

    }

}
