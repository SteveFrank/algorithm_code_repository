package com.algorithm.pro.alg_06_code;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 232 利用栈实现队列
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 * @author frankq
 * @date 2021/9/18
 */
public class Solution232 {

    private static class MyQueue {

        /**
         * 维护两个栈来实现队列
         * left  左栈 负责元素入栈
         * right 右栈 负责元素出栈
         */
        Deque<Integer> left;
        Deque<Integer> right;

        /** Initialize your data structure here. */
        public MyQueue() {
            left  = new ArrayDeque<>();
            right = new ArrayDeque<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            left.push(x);
        }

        private void reverse() {
            // 当右栈为空的时候，再将左栈内的元素全部倒入右栈，否则会破坏出栈的顺序
            if (right.isEmpty()) {
                while (! left.isEmpty()) {
                    right.push(left.pop());
                }
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            reverse();
            return right.pop();
        }

        /** Get the front element. */
        public int peek() {
            reverse();
            return right.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return left.isEmpty() && right.isEmpty();
        }
    }

}
