package com.running.pro_02_sort;

import java.util.Arrays;

import static com.running.utils.Utils.swap;

/**
 * @author frankq
 * @date 2022/1/7
 */
public class Sort_02_SelectionSort {

    public static void main(String[] args) {
        int[] a = {18, 23, 19, 9, 23, 15};
        selection(a);
    }

    private static void selection(int[] a) {
        for (int i = 0; i < a.length - 1; i ++) {
            // i 代表每轮选择最小元素需要交换到目标的索引
            // 代表最小元素的索引
            int s = i;
            for (int j = s + 1; j < a.length; j ++) {
                if (a[s] > a[j]) {
                    // j 元素比s元素还要小，更新s
                    s = j;
                }
                if (s != i) {
                    swap(a, s, i);
                }
                System.out.println(Arrays.toString(a));
            }
        }
    }

}
