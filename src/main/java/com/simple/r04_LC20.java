package com.simple;

import java.util.Stack;

/**
 * @author frankq
 * @date 2022/2/11
 */
public class r04_LC20 {

    public static void main(String[] args) {

    }

    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        // 成对出现
        if (s.length() % 2 != 0) {
            return false;
        }
        char[] ch = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        // ({[ push
        // )}] pop
        for (char c : ch) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

}
