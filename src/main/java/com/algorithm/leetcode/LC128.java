package com.algorithm.leetcode;

import java.util.HashSet;

import java.util.Set;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 */
public class LC128 {

    public static void main(String[] args) {

    }

    public int longestConsecutive(int[] nums) {
        // 1、进行初步去重处理
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longestStreak = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currnetNum = num;
                int currentStreak = 1;
                while (numSet.contains(currnetNum + 1)) {
                    currnetNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }

}
