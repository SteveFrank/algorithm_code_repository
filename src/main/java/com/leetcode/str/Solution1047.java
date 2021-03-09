package com.leetcode.str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 给出由小写字母组成的字符串S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 * 输入："abbaca"
 * 输出："ca"
 * 解释：例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，
 * 这是此时唯一可以执行删除操作的重复项。
 * 之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，
 * 所以最后的字符串为 "ca"。
 *
 * @author yangqian
 * @date 2021/3/9
 */
public class Solution1047 {

    public static void main(String[] args) {
        Solution1047 solution1047 = new Solution1047();
        // abbaca
        // aababaab
        // 还可以使用stack栈的方式处理
        System.out.println(solution1047.removeDuplicates("aababaab"));
    }

    public String removeDuplicates(String S) {
        // base case
        String dpS = "";
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i - 1) == S.charAt(i)) {
                dpS += S.charAt(i - 1);
                dpS += S.charAt(i);
                break;
            }
        }
        if (dpS.length() > 0) {
            return removeDuplicates(S.replace(dpS, ""));
        }
        return S;
    }



}
