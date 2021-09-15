package com.algorithm.pro.alg_03_code.leetcode;

import java.util.*;

/**
 * 三数之和
 * https://leetcode-cn.com/problems/3sum/
 * @author frankq
 * @date 2021/9/15
 */
public class Solution15 {

    /**
     * 解法一：耗时耗空间
     * 解法思想：类似于两数之和的思想
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        // 过滤明显不符合条件的
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }
        // n-2 中情况的twoSum
        Set<List<Integer>> set = new LinkedHashSet<>();
        for (int i = 0; i < nums.length - 2; i ++) {
            int target = - nums[i];

            Map<Integer, Integer> cache = new HashMap<>();
            for (int j = i + 1; j < nums.length; j ++) {
                if (cache.containsKey(target - nums[j])) {
                    List<Integer> list = new ArrayList<>();
                    list.add(-target);
                    list.add(nums[j]);
                    list.add(target - nums[j]);
                    list.sort(Comparator.naturalOrder());
                    set.add(list);
                } else {
                    cache.put(nums[j], j);
                }
            }
        }
        return new ArrayList<>(set);
    }

    /**
     * 使用数组排序的方式，双指针夹逼的方法（左右指针，适合已经排好序的数据）
     */
    public static List<List<Integer>> threeSum_01(int[] nums) {
        // 特殊情况直接返回
        if (nums == null || nums.length < 3) {
            return Collections.EMPTY_LIST;
        }
        Arrays.sort(nums);
        // 利用双指针的方式
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i ++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                // 跳过重复的数据
                continue;
            }
            int a = nums[i];
            // 定义双指针
            // 左指针
            int j = i + 1;
            // 右指针
            int k = nums.length - 1;
            while (j < k) {
                int b = nums[j];
                int c = nums[k];
                if ((a + b + c) == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(a);
                    list.add(b);
                    list.add(c);
                    result.add(list);
                    // 去重左右指针的重复元素
                    while (j < k && nums[j] == nums[j + 1]) {
                        j ++;
                    }
                    while (j < k && nums[k] == nums[k - 1]) {
                        k --;
                    }
                    j ++;
                    k --;
                } else if ((a + b + c) < 0) {
                    j ++;
                } else {
                    k --;
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {

    }

}
