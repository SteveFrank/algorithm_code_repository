package com.simple;

import java.util.Arrays;

/*
 * @author frankq
 * @date 2022/2/11
 */
public class r01_QuicSort {

    public static void main(String[] args) {
        int[] a = {5, 3, 7, 2, 9, 8, 1, 4};
        System.out.println(Arrays.toString(a));
        quick(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    private static void quick(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition(a, left, right);
        quick(a, left, p - 1);
        quick(a, p + 1, right);
    }

    private static int partition(int[] a, int left, int right) {
        int pv = a[left];
        int i = left;
        int j = right;
        while (i < j) {
            // j 从右边开始找小的
            while (i < j && a[j] > pv) {
                // 没有找到继续找
                j --;
            }
            if (i < j) {
                a[i] = a[j];
                i ++;
            }
            // i 从左边开始找打的
            while (i < j && a[i] <= pv) {
                i ++;
            }
            if (i < j) {
                a[j] = a[i];
                j --;
            }
        }
        a[j] = pv;
        return j;
    }

}
