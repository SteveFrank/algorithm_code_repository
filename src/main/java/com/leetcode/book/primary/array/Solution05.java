package com.leetcode.book.primary.array;

import java.util.Arrays;

/**
 * @author yangqian
 * @date 2020/10/10
 */
public class Solution05 {

    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i ++) {
            if (i - 1 == 0 && nums[0] != nums[i]) {
                return nums[0];
            }
            if (nums[i - 1] != nums[i] && nums[i - 2] != nums[i - 1]) {
                return nums[i - 1];
            }
        }
        return nums[nums.length - 1];
    }

}
