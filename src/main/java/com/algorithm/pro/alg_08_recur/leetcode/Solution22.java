package com.algorithm.pro.alg_08_recur.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author frankq
 * @date 2021/9/23
 */
public class Solution22 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        recur(0, 0, n,"", res);
        return res;
    }

    public void recur(int left, int right, int n, String s, List<String> res) {
        if (left == n && right == n) {
            res.add(s);
            return;
        }
        if (left < n) {
            String s1 = s + "(";
            recur(left + 1, right, n, s1, res);
        }
        if (right < left) {
            String s2 = s + ")";
            recur(left, right + 1, n, s2, res);
        }
    }

    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        solution22.generateParenthesis(3);
    }

}
