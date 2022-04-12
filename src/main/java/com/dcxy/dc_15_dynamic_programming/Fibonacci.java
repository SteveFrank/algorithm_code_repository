package com.dcxy.dc_15_dynamic_programming;

/**
 * @author frankq
 * @date 2022/4/12
 */
public class Fibonacci {

    public static void main(String[] args) {

    }

    // 方法一：利用数学递归公式，直接递归
    public int fib(int n) {
        // 基准情况
        if (n == 0) return 0;
        if (n == 1) return 1;
        // 递归调用
        return fib(n - 2) + fib(n - 1);
    }

}
