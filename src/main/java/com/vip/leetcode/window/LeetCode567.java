package com.vip.leetcode.window;

import java.util.HashMap;
import java.util.Map;

/**
 * @author frankq
 * @date 2023/5/1
 */
public class LeetCode567 {

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, count = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right ++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    count ++;
                }
            }
            // 只有在 right - left == need.size() 的情况下才有可能是符合条件的解
            while (right - left == s1.length()) {
                if(count == need.size())
                    return true;
                char d = s2.charAt(left);
                left++;
                if(need.containsKey(d)){
                    if(need.get(d).equals(window.get(d))){
                        count--;
                    }
                    window.put(d,window.getOrDefault(d,0)-1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }

}
