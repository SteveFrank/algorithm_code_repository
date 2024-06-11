package com.algorithm.leetcode;

import java.util.*;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词
 */
public class LC49 {

    public static void main(String[] args) {
        
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str :strs) {
            // 1、将str进行排序后作为Key，Value为List<String>
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            // 2、遇到相同的则放入Map
            String tempKey = new String(charArray);
            List<String> tempList = map.getOrDefault(tempKey, new ArrayList<>());
            tempList.add(str);
            map.put(tempKey, tempList);
        }
        // 3、取出结果放入List
        for (String key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }

}
