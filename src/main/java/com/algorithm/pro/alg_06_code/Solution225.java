package com.algorithm.pro.alg_06_code;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225 用队列实现一个栈
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 * @author frankq
 * @date 2021/9/18
 */
public class Solution225 {

    private static class MyStack {

        Queue<Integer> queue;

        /** Initialize your data structure here. */
        public MyStack() {
            queue = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue.add(x);
            for (int i = 1; i < queue.size(); i++) {
                queue.add(queue.poll());
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queue.poll();
        }

        /** Get the top element. */
        public int top() {
            return queue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

}
