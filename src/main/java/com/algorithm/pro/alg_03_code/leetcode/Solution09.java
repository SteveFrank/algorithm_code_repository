package com.algorithm.pro.alg_03_code.leetcode;

/**
 * 回文数
 * https://leetcode-cn.com/problems/palindrome-number/
 * @author frankq
 * @date 2021/9/15
 */
public class Solution09 {

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        // 转为字符数组
        String value = String.valueOf(x);
        char[] vs = value.toCharArray();
        int first = 0;
        int last = vs.length - 1;
        while (first != last) {
            if (vs[first] != vs[last]) {
                return false;
            }
            first ++;
            if (first == last) {
                return true;
            }
            last --;
        }
        return true;
    }

    public static boolean isPalindrome_01(int x) {
        // x是负数或者x的末尾为0肯定不是回文数，但是需要排除0本身
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        // 将x的后半段翻转，构造一个新的数与前面的数做比较
        int revertNum = 0;
        while (x > revertNum) {
            revertNum = revertNum * 10 + x % 10;
            x = x / 10;
        }
        return x == revertNum || x == revertNum / 10;
    }

    public static void main(String[] args) {

    }

}
