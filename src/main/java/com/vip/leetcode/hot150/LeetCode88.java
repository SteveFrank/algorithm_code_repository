package com.vip.leetcode.hot150;

import java.util.Arrays;

public class LeetCode88 {

    /**
     * 88. 合并两个有序数组
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        // 获得总的长度
        int len = m + n - 1;
        while (len1 >= 0 && len2 >= 0) {
            nums1[len --] = nums1[len1] > nums2[len2] ? nums1[len1 --] : nums2[len2 --];
        }
        // 如果nums2 还有剩余，可以直接使用该剩余的数组拷贝进nums1中
        System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

}
