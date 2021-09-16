package com.algorithm.pro.alg_04_stack.leetcode;

import java.util.Stack;

/**
 * 155 最小栈
 * https://leetcode-cn.com/problems/min-stack/
 * @author frankq
 * @date 2021/9/16
 */
public class Solution155 {

    class MinStack {

        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        /**
         * 使用两个栈
         * 利用辅助栈的方式操作
         */
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            }
        }

        public void pop() {
            int top = stack.pop();
            if (top == minStack.peek()) {
                minStack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    public static void main(String[] args) {

    }

}
