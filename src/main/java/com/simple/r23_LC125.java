package com.simple;

/**
 * @author frankq
 * @date 2022/2/17
 */
public class r23_LC125 {

    public static void main(String[] args) {
        System.out.println((int)'A');
        System.out.println((int)'a');
    }

    public boolean isPalindrome(String s) {
        // 去除不需要的符号
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left))
                        != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }

}
