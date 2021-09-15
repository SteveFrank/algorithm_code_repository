package com.algorithm.pro.alg_03_code.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 * @author frankq
 * @date 2021/9/15
 */
public class Solution01 {

    /**
     * 缓存 时间复杂度 O(n)
     */
    public static int[] twoSum(int[] nums, int target) {
        // 构造缓存
        Map<Integer, Integer> cache = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (cache.containsKey(target - nums[i])) {
                return new int[]{cache.get(target - nums[i]), i};
            }
            cache.put(nums[i], i);
        }
        return new int[] {};
    }

    public static void main(String[] args) {

    }

}
