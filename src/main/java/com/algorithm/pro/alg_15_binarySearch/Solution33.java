package com.algorithm.pro.alg_15_binarySearch;

/**
 * @author frankq
 * @date 2022/1/27
 */
public class Solution33 {

    public int search(int[] nums, int target) {
        // 此处的left 和 right 代表的是下标
        int left = 0, right = nums.length - 1, mid = 0;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            // 前半部分有序
            if (nums[left] <= nums[mid]) {
                // target 如果在前半部分则在前半部分寻找，否则在后半部分寻找
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 后半部分有序
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }

}
