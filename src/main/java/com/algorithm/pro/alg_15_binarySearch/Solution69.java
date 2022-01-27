package com.algorithm.pro.alg_15_binarySearch;

/**
 * @author frankq
 * @date 2022/1/27
 */
public class Solution69 {

    public int mySqrt(int x) {
        // 特殊判断
        if (x <= 1) {
            return x;
        }
        // 找一个数k, k^2 <= x 找到一个最大的k就是我们需要的
        long left = 1, right = x >> 1, mid = 0;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (mid * mid < x) {
                left = mid + 1;
            } else if (mid * mid > x) {
                right = mid - 1;
            } else {
                return (int) mid;
            }
        }
        return (int) left - 1;
    }

    public static void main(String[] args) {

    }

}
