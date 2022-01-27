package com.algorithm.pro.alg_14_greedy;

/**
 * @author frankq
 * @date 2022/1/26
 */
public class Solution55 {

    public static boolean canJump(int[] nums) {
        // 跳跃的最远距离
        int farthest = 0;
        for (int i = 0; i < nums.length; i ++) {
            // farthest 到某个位置走不下去
            if (i > farthest) {
                return false;
            }
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{0};
        boolean res = canJump(nums);
        System.out.println(res);
    }

}
