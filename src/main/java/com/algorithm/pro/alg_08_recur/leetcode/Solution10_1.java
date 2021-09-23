package com.algorithm.pro.alg_08_recur.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指Offer 10_1 斐波那契数列
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 * @author frankq
 * @date 2021/9/23
 */
public class Solution10_1 {

    Map<Integer, Integer> hash = new HashMap<>();

    public int fib(int n) {
        if (n < 2) {
            hash.put(n, n);
            return n;
        } else {
            if (hash.containsKey(n)) {
                return hash.get(n);
            }
            int x = fib(n - 1) % 1000000007;
            hash.put(n - 1, x);
            int y = fib(n - 2) % 1000000007;
            hash.put(n - 2, y);
            int z = (x + y) % 1000000007;
            hash.put(n, z);
            return z;
        }
    }

    public static void main(String[] args) {

    }

}
