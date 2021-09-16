package com.algorithm.pro.alg_03_code.leetcode;

/**
 * 02. 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 * @author frankq
 * @date 2021/9/16
 */
public class Solution02 {

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 首先题目中头节点作为个位，需要注意此处
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // 定义一个进位值，进位值肯定是小于10的
        int carry = 0;
        ListNode result = new ListNode(-1);
        ListNode temp = result;
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int c = (a + b + carry) % 10;
            carry = (a + b + carry) / 10;
            result.next = new ListNode(c);
            // 3个链表依次后移
            result = result.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // 如果carry还是需要进位则继续
        if (carry > 0) {
            result.next = new ListNode(carry);
        }
        return temp.next;
    }

    public static void main(String[] args) {

    }

}
