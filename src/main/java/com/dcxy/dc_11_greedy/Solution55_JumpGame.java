package com.dcxy.dc_11_greedy;

/**
 * @author frankq
 * @date 2022/2/9
 */
public class Solution55_JumpGame {

    /**
     * 遍历数组中的每个位置，并且实时更新当前最远可以到达的位置，记录为 farthest
     * 如果最远举例都不足，肯定无法达到
     */
    public boolean canJump(int[] nums) {
        int farthest = 0;
        // 遍历数组，更新farthest
        for (int i = 0; i < nums.length; i ++) {
            if (i <= farthest) {
                farthest = Math.max(farthest, i + nums[i]);
                if (farthest >= nums.length - 1) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[10];
        int farthest = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (i <= farthest) {
                farthest = Math.max(farthest, i + nums[i]);
                if (farthest >= nums.length - 1) {
                    // true
                }
            } else {
                // false
            }
        }
        // false
    }

}
