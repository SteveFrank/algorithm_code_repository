package com.simple;

/**
 * @author frankq
 * @date 2022/4/12
 */
public class r27_LC69 {

    public static void main(String[] args) {

    }

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int left = 1;
        int right = x / 2;
        // 区间寻找发
        while (left < right) {
            int mid = (left + right) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

}
