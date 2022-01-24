package com.algorithm.pro;

import java.util.ArrayList;
import java.util.List;

/**
 * @author frankq
 * @date 2021/12/21
 */
public class Practice {

    public static void main(String[] args) {
        List<String> res = generateParenthesis(3);
        System.out.println(res);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        recur(0, 0, n, "+", res);
        return res;
    }

    public static void recur(int left, int right, int n, String s, List<String> res) {
        // 退出条件
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

}
