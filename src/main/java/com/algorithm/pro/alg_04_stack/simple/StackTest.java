package com.algorithm.pro.alg_04_stack.simple;

/**
 * @author frankq
 * @date 2021/9/16
 */
public class StackTest {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);

        System.out.println(stack.peek());

        System.out.println("=============================");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println("=============================");
    }

}
