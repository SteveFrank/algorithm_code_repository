package com.algorithm.pro.alg_03_code.leetcode;

/**
 * 加1
 * https://leetcode-cn.com/problems/plus-one/
 * @author frankq
 * @date 2021/9/15
 */
public class Solution66 {

    /**
     * 进位1
     */
    public static int[] plusOne(int[] digits) {
        // 从数组的最后一位下标为1开始计算
        // 向下后面还有一位，向前推进1位
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i --) {
            int temp = digits[i];
            // 对10求余的结果
            digits[i] = (temp + carry) % 10;
            // 向前一位的进位
            carry = (temp + carry) / 10;
            // 此时如果没有进位了则进行break
            if (carry == 0) {
                break;
            }
        }
        if (carry > 0) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
        return digits;
    }

    public static void main(String[] args) {

    }

}
