package com.algorithm.pro.alg_07_hash.leetcode;

/**
 *
 * 滑动窗口经典问题
 * 76 最小覆盖子串
 * https://leetcode-cn.com/problems/minimum-window-substring/
 *
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 * @author frankq
 * @date 2021/9/22
 */
public class Solution76 {

    public String minWindow(String s, String t) {

        // 特殊判断
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        // 构造两个哈希表
        // 字典：记录t中所有字符及其出现的次数
        int[] dict = new int[128];
        // 记录滑动窗口中每个字符出现的次数
        int[] window = new int[128];

        // 记录s
        for (int i = 0; i < t.length(); i ++) {
            dict[t.charAt(i)] ++;
        }

        // 定义滑动窗口左右边界指针 left right
        int left, right;
        left = right = 0;
        // 定义窗口内已有字典中字符个数
        int count = 0;
        // 定义窗口的最小长度
        int min = s.length() + 1;
        // 定义返回的字符串
        String res = "";

        while (right < s.length()) {
            char cr = s.charAt(right);
            window[cr] ++;
            // 此时进入窗口的字符判断是否在t中
            if (dict[cr] > 0 && dict[cr] >= window[cr]) {
                count ++;
            }
            right ++;
            // 当窗口内完全包含t中所有字符时，窗口开始进行收缩
            while (count == t.length()) {
                // 缩小窗口求最小窗口
                char cl = s.charAt(left);
                // 如果要移除窗口的这个字符是字典中的，则窗口不可以再进行收缩
                if (dict[cl] > 0 && dict[cl] >= window[cl]) {
                    count --;
                    if (right - left < min) {
                        min = right - left;
                        res = s.substring(left, right);
                    }
                }
                window[cl] --;
                left ++;
            }
        }

        return res;
    }

    public static void main(String[] args) {

    }

}
