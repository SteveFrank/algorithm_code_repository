package com.algorithm.pro.alg_07_hash.leetcode;

/**
 * @author frankq
 * @date 2021/9/22
 */
public class Solution21 {

     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 使用快满指针 & 哨兵的思想
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode l3 = new ListNode(-1);
        ListNode result = l3;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                l3.next = l1;
                l1 = l1.next;
            } else {
                l3.next = l2;
                l2 = l2.next;
            }
            l3 = l3.next;
        }
        if (l1 != null) {
            l3.next = l1;
        }
        if (l2 != null) {
            l3.next = l2;
        }
        return result.next;
    }

    public static void main(String[] args) {

    }

}
