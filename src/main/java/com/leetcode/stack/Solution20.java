package com.leetcode.stack;

import java.util.*;

/**
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * @author yangqian
 * @date 2021/2/24
 */
public class Solution20 {

    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        System.out.println(solution20.isValid1("(){}}{"));
        System.out.println(solution20.isValid2("(){}}{"));
    }

    /**
     * bad
     * @param s
     * @return
     */
    public boolean isValid1(String s) {
        // 利用一个栈和一个队列来存储信息
        Set<Character> left = new HashSet<>();
        left.add('(');
        left.add('{');
        left.add('[');
        Set<Character> right = new HashSet<>();
        right.add(')');
        right.add('}');
        right.add(']');

        Map<Character, Character> characterMap = new HashMap<>(3);
        characterMap.put('(', ')');
        characterMap.put('{', '}');
        characterMap.put('[', ']');

        Stack<Character> leftStack = new Stack<>();
        Queue<Character> rightQueue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (left.contains(c)) {
                leftStack.add(c);
            }
            if (right.contains(c)) {
                rightQueue.offer(c);
            }
        }
        return leftStack.isEmpty();
    }

    /**
     * use
     * @param s
     * @return
     */
    public boolean isValid2(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        Map<Character, Character> pairs = new HashMap<Character, Character>(3) {
            private static final long serialVersionUID = 8292581551295924569L;
            {
                put(')', '(');
                put(']', '[');
                put('}', '{');
        }};
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || !stack.peek().equals(pairs.get(ch))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

}
