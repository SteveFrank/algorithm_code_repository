package com.labuladong.chapter0.window;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 * @author yangqian
 * @date 2021/4/1
 */
public class Solution76 {

    public static void main(String[] args) {
        String result = new Solution76().minWindow("ADOBECODEBANC", "ABC");
        System.out.println(result);
    }

    /**
     *
     * 1、在字符串S中使用双指针中的左右指针技巧，初始化 left = right = 0
     * 把索引左闭右开的 [left, right) 区间称为一个窗口
     * 2、我们先不断增加 right 指针扩大窗口 [left, right)，
     * 知道窗口中的字符串符合要求（包含T中的所有字符）
     * 3、此时，停止增加right，转而不断增加left指针缩小窗口[left, right),
     * 知道窗口中的字符串不在符合要有，同时每次增加left，更新一轮结果
     *
     * 4、重复 第2和第3 步骤，直到right到达字符串到达字符串S的尽头
     *
     *
     * @return
     */
    public String minWindow(String s, String t) {
        Map<Character, Integer> needs = new HashMap<>();
        // 窗口Map
        Map<Character, Integer> window = new HashMap<>();
        for (char ch : t.toCharArray()) {
            // 每个字符出现的次数后续使用
            int sum = needs.getOrDefault(ch, 0) + 1;
            needs.put(ch, sum);
        }
        int left = 0, right = 0;
        int valid = 0;

        // 记录最小覆盖子串的其实索引以及长度
        int start = 0, len = Integer.MAX_VALUE;

        while (right < s.length()) {
            // 准备将 c 字符移入窗口
            char c = s.charAt(right);
            // 右移 窗口
            right ++;
            // 进入窗口内数据的更新
            if (needs.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(needs.get(c))) {
                    valid ++;
                }
            }
            // 判断左侧窗口是否要收缩
            while (valid == needs.size()) {
                // 在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    left = right - left;
                }
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 左移窗口
                left ++;
                // 进行窗口内数据更新
                if (needs.containsKey(d)) {
                    if (window.get(d).equals(needs.get(d))) {
                        valid --;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, len);
    }

}
