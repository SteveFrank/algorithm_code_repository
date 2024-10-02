package com.bytedance.demo20241001;

import java.util.Arrays;

public class Solution27 {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        int val = 3;
        int result = removeElement(nums, val);
        System.out.println("=============================");
        System.out.println(result);
        System.out.println(Arrays.toString(nums));
        System.out.println("=============================");
    }

    public static int removeElement(int[] nums, int val) {
        int[] result = new int[nums.length];
        int j = 0;
        for (int num : nums) {
            if (num != val) {
                result[j++] = num;
            }
        }
        if (j >= 0) System.arraycopy(result, 0, nums, 0, j);
        return j;
    }

    public static int removeElementSolution2(int[] nums, int val) {
        int left = 0, length = nums.length;
        for (int right = 0; right < length; right ++) {
            if (nums[right] != val) {
                nums[left ++] = nums[right];
            }
        }
        return left;
    }

}
