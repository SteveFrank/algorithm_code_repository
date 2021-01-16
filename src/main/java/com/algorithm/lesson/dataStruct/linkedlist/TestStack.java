package com.algorithm.lesson.dataStruct.linkedlist;

import java.util.Stack;

/**
 *
 * 栈的基本使用
 *
 * @author yangqian
 * @date 2021/1/16
 */
public class TestStack {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.add("jack");
        stack.add("tom");
        stack.add("smith");

        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

}
