package com.algorithm.pro.alg_15_binarySearch;

/**
 * @author frankq
 * @date 2022/1/27
 */
public class Solution153 {

    /**
     * 二分查找，但是不能够套用简单的二分查找模板，修改二分的判断条件
     */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, mid = 0;
        /*
         * 在这里如果left == right则可以直接返回，最小的元素一定是它
         */
        while (left < right) {
            mid = (left + right) >> 1;
            if (nums[mid] < nums[right]) {
                // 右区间联系，最小值一定在左半区间
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {

    }

}
