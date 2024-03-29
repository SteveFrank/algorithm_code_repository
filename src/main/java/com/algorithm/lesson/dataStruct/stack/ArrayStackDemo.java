package com.algorithm.lesson.dataStruct.stack;

import java.util.Scanner;

/**
 * @author yangqian
 * @date 2021/1/16
 */
public class ArrayStackDemo {

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true;
        final Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 表示添加数据到栈(入栈)");
            System.out.println("pop: 表示从栈取出数据(出栈)");
            System.out.println("请输入你的选择:");
            key = scanner.next();
            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数:");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈的数据:%d\n", res);
                    } catch (Exception e) {
                        System.out.println("栈空，没有数据~~");
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出 ~~");
    }

}

class ArrayStack {
    /**
     * 栈大小
     */
    private int maxSize;
    /**
     * 数组，模拟栈
     */
    private int[] stack;
    /**
     * top 标识栈顶指针，初始化为-1
     */
    private int top = -1;

    /**
     * 构造器
     * @param maxSize
     */
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    /**
     * 栈满
     * @return
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        /*
         * 栈是否满
         */
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top ++;
        stack[top] = value;
    }

    public int pop() {
        // 栈是否空
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top --;
        return value;
    }

    /**
     * 遍历栈，遍历时，需要从栈顶显示数据
     */
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，没有数据~");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

}

