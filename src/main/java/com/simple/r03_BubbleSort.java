package com.simple;

import java.util.Arrays;

/**
 * @author frankq
 * @date 2022/2/11
 */
public class r03_BubbleSort {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        bubble_v1(a);
        System.out.println(Arrays.toString(a));
    }

    public static void bubble_v1(int[] a) {
        int n = a.length - 1;
        while (true) {
            // 表示最后一次交换索引位置
            int last = 0;
            for (int i = 0; i < n; i++) {
                System.out.println("比较次数:" + i);
                if (a[i] > a[i + 1]) {
                    swap(a, i, i + 1);
                    last = i;
                }
            }
            n = last;
            if (n == 0) {
                break;
            }
        }
    }

    private static void swap(int[] a, int l, int r) {
        int temp = a[r];
        a[r] = a[l];
        a[l] = temp;
    }

}
