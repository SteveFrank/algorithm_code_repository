package com.vip.leetcode.oneday.may2023;

/**
 * @author frankq
 * @date 2023/5/3
 */
public class Day03_LeetCode1003 {

    public boolean isValid(String s) {
        StringBuilder stk = new StringBuilder();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            stk.append(c);
            if (stk.length() >= 3 && stk.substring(stk.length() - 3).equals("abc")) {
                stk.delete(stk.length() - 3, stk.length());
            }
        }
        return stk.isEmpty();
    }

    public static void main(String[] args) {

    }

}
