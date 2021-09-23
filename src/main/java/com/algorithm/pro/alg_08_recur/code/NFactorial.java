package com.algorithm.pro.alg_08_recur.code;

/**
 * @author frankq
 * @date 2021/9/23
 */
public class NFactorial {

    public int fac(int n) {
        // 终止条件
        if (n <= 1) {
            return 1;
        }
        return n * fac(n - 1);
    }

}
