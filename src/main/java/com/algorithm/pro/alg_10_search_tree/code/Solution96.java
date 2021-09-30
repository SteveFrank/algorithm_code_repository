package com.algorithm.pro.alg_10_search_tree.code;

import java.util.HashMap;
import java.util.Map;

/**
 * @author frankq
 * @date 2021/9/30
 */
public class Solution96 {

//    public int numTrees(int n) {
//        if (n <= 1) {
//            return 1;
//        }
//        int sum = 0;
//        for (int i = 1; i <= n; i++) {
//            sum += numTrees(i - 1) * numTrees(n - i);
//        }
//        return sum;
//    }

    public int numTrees(int n) {
        return recur(n, new HashMap<>());
    }

    public int recur(int n, Map<Integer, Integer> map) {
        if (n <= 1) {
            map.put(n, 1);
            return 1;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += recur(i-1, map) * recur(n-i, map);
        }
        map.put(n, sum);
        return sum;
    }

    public static void main(String[] args) {

    }

}
