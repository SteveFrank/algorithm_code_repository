package com.running.pro_02_sort;

import com.running.utils.Utils;

import java.util.Arrays;

/**
 * @author frankq
 * @date 2022/1/7
 */
public class Sort_01_BubbleSort {

    public static void main(String[] args) {
        int[] a = {5, 2, 7, 4, 1, 3, 8, 9};
        bubble_v2(a);
    }

    public static void bubble_v2(int[] a) {
        int n = a.length - 1;
        int j = 1;
        while (true) {
            // 表示最后一次交换索引的位置
            int last = 0;
            for (int i = 0; i < n; i ++) {
                System.out.println("比较次数:" + i);
                if (a[i] > a[i + 1]) {
                    Utils.swap(a, i, i + 1);
                    last = i;
                }
            }
            n = last;
            System.out.println("第" + (j++) + "轮冒泡" + Arrays.toString(a));
            if (n == 0) {
                break;
            }
        }
    }

    public static void bubble_v1(int[] a) {
        for (int j = 0; j < a.length - 1; j ++) {
            // 一轮冒泡
            // 是否发生了交换
            boolean swapped = false;
            for (int i = 0; i < a.length - 1 - j; i ++) {
                System.out.println("比较次数:" + i);
                if (a[i] > a[i + 1]) {
                    Utils.swap(a, i ,i + 1);
                    swapped = true;
                }
            }
            System.out.println("第" + j + "轮冒泡" + Arrays.toString(a));
            // 如果没有发生交换，则说明数据有序了
            if (!swapped) {
                break;
            }
        }
    }

}
