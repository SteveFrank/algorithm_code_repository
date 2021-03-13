package com.leetcode.simple;

import java.util.Deque;
import java.util.LinkedList;


/**
 *
 * 331 验证二叉树的前序序列化
 *
 * @author yangqian
 * @date 2021/3/12
 */
public class Solution331 {

    public static void main(String[] args) {

    }

    public boolean isValidSerialization(String preorder) {
        int n = preorder.length();
        int i = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(1);
        while (i < n) {
            // base case
            if (stack.isEmpty()) {
                return false;
            }
            if (preorder.charAt(i) == ',') {
                // 分离逗号
                i ++;
            } else if (preorder.charAt(i) == '#') {
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                i ++;
            } else {
                // 读取一个数字
                while (i < n && preorder.charAt(i) != ',') {
                    i++;
                }
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                stack.push(2);
            }
        }
        return stack.isEmpty();
    }

}
