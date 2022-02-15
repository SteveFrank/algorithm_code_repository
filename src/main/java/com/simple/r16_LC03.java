package com.simple;
import java.util.HashSet;
import java.util.Set;


/**
 * @author frankq
 * @date 2022/2/14
 */
public class r16_LC03 {

    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        // 特殊判断
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left, right;
        left = right = 0;
        Set<Character> set = new HashSet<>();
        int max = 0;
        while (right < s.length()) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left ++;
            }
            set.add(s.charAt(right));
            right ++;
            max = Math.max(max, right - left);
        }
        return max;
    }

}
