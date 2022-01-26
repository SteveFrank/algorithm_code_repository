package com.algorithm.pro.alg_14_greedy;

import java.util.Arrays;

/**
 * @author frankq
 * @date 2022/1/26
 */
public class Solution455 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int max = 0;

        int i = 0;
        int j = 0;
        while(i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                i ++;
                j ++;
                max ++;
            } else {
                j ++;
            }
        }
        return max;
    }



    public static void main(String[] args) {

    }

}
