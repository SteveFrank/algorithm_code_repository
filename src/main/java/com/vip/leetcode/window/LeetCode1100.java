package com.vip.leetcode.window;

import java.util.HashMap;
import java.util.Map;

/**
 * 长度为 K 的无重复字符子串
 * 给你一个字符串 S，找出所有长度为 K 且不含重复字符的子串，请你返回全部满足要求的子串的 数目。
 *
 * @author frankq
 * @date 2023/5/1
 */
public class LeetCode1100 {

    public int numKLenSubstrNoRepeats(String s, int k) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        // 判断右指针边界
        while (right < s.length()) {
            // 右指针开始扩大区间
            char c = s.charAt(right);
            right ++;
            // 窗口内数据更新
            window.put(c, window.getOrDefault(c, 0) + 1);

            // 在上一次循环中保证了无重复的罗
            if (window.get(c) == 1 && (right - left == k)) {
                res++;
                window.put(s.charAt(left), window.get(s.charAt(left)) - 1);
                left++;
                continue;
            }

            // 窗口内出现重复数据
            while (window.get(c) > 1) {
                // 当前包含有重复的字符串
                char d = s.charAt(left);
                left ++;
                window.put(d, window.get(d) - 1);
            }

        }
        return res;
    }

    public static void main(String[] args) {

    }

}
