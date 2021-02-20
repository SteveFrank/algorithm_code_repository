package com.algorithm.lesson.algorithm.recursion;

/**
 * 八皇后问题
 * @author yangqian
 * @date 2021/2/17
 */
public class Queue8 {

    /**
     * 定义一个max表示一共有多少个皇后
     */
    private int max = 8;
    /**
     * 定义数组array,保存皇后防止的位置结果,进行比较
     * 对应的下标，标识第几行，第几个皇后
     */
    private int[] array = new int[max];
    /**
     * 统计解法总数
     */
    private static int count = 0;
    /**
     * 判断的总数
     */
    private static int judgeCount = 0;

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("一共有 %d 解法", count);
        System.out.println();
        System.out.printf("一共判断冲突的次数 %d 次", judgeCount);
    }

    /**
     * 编写一个方法放置第n个皇后
     * check的每一次递归都会进入到check中，都会有一次递归循环
     * 因此会有回溯
     */
    private void check(int n) {
        if (n == max) {
            // n == 8的时候，其实8个皇后就已经放好了
            print();
            return;
        }
        // 依次放入皇后，并且判断是否存在冲突
        for (int i = 0; i < max; i++) {
            // 先放置皇后n
            array[n] = i;
            // 判断是否冲突
            if (judge(n)) {
                // 不冲突，接着放n+1个皇后，即开始进行递归
                // 回溯
                check(n + 1);
            }
            // 如果冲突，就继续执行array[n] = i; 即将第n个皇后，放置在本行的后移一个位置
        }
    }

    /**
     * 查看当我们放置第n个皇后，就去检测该皇后是否和前面已经放置的皇后冲突
     * @param n 表示第n个皇后
     * @return
     */
    private boolean judge(int n) {
        judgeCount ++;
        for (int i = 0; i < n; i++) {
            // 1、array[i] == array[n] 判断第n个皇后是否和前面的n-1个皇后在同一列
            // 2、Math.abs(n - i) == Math.abs(array[n] - array[i]) 是否在同一个斜线上
            // 3、是否在同一行（没有必要判断）
            if (array[i] == array[n]
                    || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印皇后摆放的位置
     */
    private void print() {
        count ++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
