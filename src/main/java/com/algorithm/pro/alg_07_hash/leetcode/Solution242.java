package com.algorithm.pro.alg_07_hash.leetcode;

/**
 * @author frankq
 * @date 2021/9/22
 */
public class Solution242 {

    public static boolean isAnagram(String s, String t) {
        // 特殊判断
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        // 构造hash表
        int[] hashtable = new int[26];
        for (int i = 0; i < s.length(); i ++) {
            hashtable[hash(s.charAt(i))] ++;
        }
        for (int i = 0; i < t.length(); i ++) {
            hashtable[hash(t.charAt(i))] --;
            if (hashtable[hash(t.charAt(i))] < 0) {
                return false;
            }
        }
        return true;
    }

    public static int hash(char key) {
        return key - 'a';
    }

    public static void main(String[] args) {

    }

}
