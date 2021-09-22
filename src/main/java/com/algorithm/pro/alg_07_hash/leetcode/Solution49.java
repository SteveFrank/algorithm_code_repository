package com.algorithm.pro.alg_07_hash.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author frankq
 * @date 2021/9/22
 */
public class Solution49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        // 特殊判断
        if (strs == null || strs.length < 1) {
            return new ArrayList<>();
        }
        // 使用map
        Map<String, List<String>> map = new HashMap<>(strs.length);
        for (String str : strs) {
            String key = genKey(str);
            List<String> res = map.getOrDefault(key, new ArrayList<>());
            res.add(str);
            map.put(key, res);
        }
        return new ArrayList<>(map.values());
    }

    public String genKey(String str) {
        int[] table = new int[26];
        for (int i = 0; i < str.length(); i ++) {
            table[str.charAt(i) - 'a'] ++;
        }
        StringBuilder sb = new StringBuilder();
        for (int j : table) {
            sb.append("-").append(j);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }

}
