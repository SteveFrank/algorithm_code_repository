package com.simple;

/**
 * @author frankq
 * @date 2022/2/11
 */
public class r02_BinarySearch {

    public static void main(String[] args) {
        int[] array = {-1,0,3,5,9,12};
        int target = 13;
        System.out.println(binarySearch(array, target));
    }

    public static int binarySearch(int[] a, int t) {
        int l = 0, r = a.length - 1, m;
        while (l <= r) {
            m = (l + r) / 2;
            if (a[m] == t) {
                return m;
            } else if (a[m] > t) {
                r = m - 1;
            } else if (a[m] < t) {
                l = m + 1;
            }
        }
        return -1;
    }

}
