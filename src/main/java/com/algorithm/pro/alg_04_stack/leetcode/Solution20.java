package com.algorithm.pro.alg_04_stack.leetcode;

import java.util.Stack;

/**
 * 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 * @author frankq
 * @date 2021/9/16
 */
public class Solution20 {

    public static boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        char[] t = s.toCharArray();
        // 如果是奇数必然不符合要求
        if (t.length % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char ch : t) {
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

    public static void main(String[] args) {

    }

}
