package com.algorithm.pro.alg_03_code.leetcode;

/**
 * @author frankq
 * @date 2021/9/16
 */
public class Solution24 {

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

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;

        // 提供一个哨兵
        ListNode temp = head.next;

        while (head != null && head.next != null) {
            ListNode next = head.next;
            ListNode next_next = next.next;

            next.next = head;
            head.next = next_next;
            pre.next = next;

            pre = head;
            head = next_next;
        }
        return temp;

    }

    public static void main(String[] args) {

    }

}
