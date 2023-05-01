package com.vip.leetcode.window;

import java.util.HashMap;
import java.util.Map;

/**
 * @author frankq
 * @date 2023/4/29
 */
public class LeetCode03 {

    /**
     * 利用滑动窗口解题
     */
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        // 判断右指针边界
        while (right < s.length()) {
            char c = s.charAt(right);
            right ++;
            // 窗口内数据更新
            window.put(c, window.getOrDefault(c, 0) + 1);
            // 判断左侧的窗口是否需要收缩
            while (window.get(c) > 1) {
                // 说明窗口中出现了两次了
                char d = s.charAt(left);
                // 左指针往前
                left ++;
                // 进行窗口内数据的更新
                window.put(d, window.get(d) - 1);
            }
            // 更新最新的答案
            res = Math.max(res, right - left);
        }
        return res;
    }

    public static void main(String[] args) {

    }

}
