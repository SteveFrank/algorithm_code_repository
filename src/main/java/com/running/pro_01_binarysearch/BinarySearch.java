package com.running.pro_01_binarysearch;

/**
 * @author frankq
 * @date 2022/1/7
 */
public class BinarySearch {

    public static void main(String[] args) {
        // 二分查找的前提必须保证数组的有序
        int[] array = {1, 5, 8, 11, 19, 22, 31, 35, 40, 45, 48, 49, 50};
        int target = 48;
        int idx = binarySearch(array, target);
        System.out.println(idx);
    }

    // 二分查找
    public static int binarySearch(int[] a, int t) {
        int l = 0, r = a.length - 1, m;
        while (l <= r) {
            m = (l + r) / 2;
            if (a[m] == t) {
                return m;
            } else if (a[m] > t) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

}
