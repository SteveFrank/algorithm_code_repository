package com.algorithm.pro.array.leetcode;

/**
 * LeetCode
 * https://leetcode-cn.com/problems/move-zeroes/
 * @author frankq
 * @date 2021/9/14
 */
public class Solution283 {

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 算法思想：双指针思想，快慢指针的思想
     * 复杂度：时间复杂度O(n) 空间复杂度O(1)
     */
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        // 从前到后非零元素的指针
        int p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[p1] = nums[i];
                p1 ++;
            }
        }
        while(p1 < nums.length) {
            nums[p1] = 0;
            p1 ++;
        }
    }

    /**
     * 快慢指针，在一次循环中完成操作
     */
    public static void moveZeroes_1(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        // 定义两个指针
        int i = 0;
        int j = 0;
        for (; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j ++;
            }
        }
    }

    public static void main(String[] args) {

    }

}
