package com.bytedance;

import java.util.*;

/**
 * @author frankq
 * @date 2023/7/11
 */
public class Lesson03 {

    public static void main(String[] args) {

    }


    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0, right = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            while (set.contains(s.charAt(left))) {
                set.remove(s.charAt(left));
                left ++;
            }
            set.add(s.charAt(right));
            right ++;
            max = Math.max(max, right - left);
        }
        return max;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            if (cache.containsKey(target - nums[i])) {
                return new int[]{cache.get(target - nums[i]), i};
            }
            cache.put(nums[i], i);
        }
        return new int[]{};
    }

    public String longestPalindrome(String s) {

        return "";
    }

    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        char[] chArr = s.toCharArray();
        if (chArr.length % 2 != 0) {
            return false;
        }
        // 定义栈结构
        Stack<Character> stack = new Stack<>();
        for (char ch : chArr) {
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '{') {
                stack.push('}');
            } else if (ch == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || ch != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
