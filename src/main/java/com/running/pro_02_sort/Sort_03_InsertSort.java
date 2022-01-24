package com.running.pro_02_sort;

import java.util.Arrays;

/**
 * @author frankq
 * @date 2022/1/7
 */
public class Sort_03_InsertSort {

    public static void main(String[] args) {
        int[] a = {7, 5, 19, 8, 4, 1};
        insert(a);
    }

    // 修改代码保证希尔排序一直
    public static void insert(int[] a) {
        // i 代表带插入元素的索引
        for (int i = 1; i < a.length; i++) {
            int t = a[i];
            int j = i;
            System.out.println(j);
            while (j >= 1) {
                if (t < a[j - 1]) {
                    // j-1 是上一个元素的索引，如果大于t，则进行后移
                    a[j] = a[j - 1];
                    j --;
                } else {
                    // 如果 j-1 已经小于等于t，则j就是插入位置
                    break;
                }
            }
            a[j] = t;
            System.out.println(Arrays.toString(a) + " " + j);
        }
    }

}
