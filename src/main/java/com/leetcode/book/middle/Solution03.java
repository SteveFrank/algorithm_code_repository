package com.leetcode.book.middle;


/**
 * LC 旋转数组
 * @author yangqian
 * @date 2020/10/10
 */
public class Solution03 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2};
        Solution03 solution03 = new Solution03();
        solution03.rotate(nums, 3);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     */
    public void rotate(int[] nums, int k) {
        int[] result = new int[nums.length];
        int start = 0;
        int startIndex = 0;
        if (nums.length > 0) {
            if (k < nums.length) {
                start = k;
            } else {
                start = k - nums.length;
            }
            startIndex = nums.length - start - 1;
            int startFirst = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i <= startIndex) {
                    result[start] = nums[i];
                    start ++;
                } else {
                    result[startFirst] = nums[i];
                    startFirst ++;
                }
            }
        }
        System.arraycopy(result, 0, nums, 0, result.length);
    }

}
