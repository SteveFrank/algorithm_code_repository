package com.algorithm.lesson.algorithm.recursion;

/**
 *
 * 递归的基本概念：
 *  方法自己调用自己，每次都拥有不同的变量
 *  1、应用：回溯（递归）
 *  2、调用机制：图解（JVM 栈）
 *
 *  八皇后问题、汉诺塔、阶乘问题、迷宫问题、球、篮子问题
 *  
 * @author yangqian
 * @date 2021/1/17
 */
public class RecursionTest {

    public static void main(String[] args) {
//        test(4);
        System.out.println(factorial(4));
    }

    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }
        System.out.println("n = " + n);
    }

    /**
     * 阶乘问题
     * @param n
     * @return
     */
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            // 1 * 2 * 3
            return factorial(n - 1) * n;
        }
    }

}
