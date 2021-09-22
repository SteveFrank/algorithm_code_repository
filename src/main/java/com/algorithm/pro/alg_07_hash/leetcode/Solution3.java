package com.algorithm.pro.alg_07_hash.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author frankq
 * @date 2021/9/22
 */
public class Solution3 {

    /**
     * 利用滑动窗口的思想进行求解
     */
    public static int lengthOfLongestSubstring(String s) {
        // 特殊判断
        if (s == null || s.length() < 1) {
            return 0;
        }
        int left, right;
        left = right = 0;
        // 用于判断是否有重复字符
        Set<Character> set = new HashSet<>();
        // 定义最大值
        int max = 0;
        while (right < s.length()) {
            // 当窗口需要进行缩小的时候
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left ++;
            }
            set.add(s.charAt(right));
            right ++;
            max = Math.max(max, set.size());
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

}
