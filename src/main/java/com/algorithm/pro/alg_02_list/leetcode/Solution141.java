package com.algorithm.pro.alg_02_list.leetcode;

/**
 * 环形链表（是否有环）
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * @author frankq
 * @date 2021/9/15
 */
public class Solution141 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public boolean hasCycle(ListNode head) {
        // 特殊判断
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        // 两个指针分别向下走
        do {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == null || fast.next == null) {
                return false;
            }
        } while (fast != slow);
        return true;
    }

    public static void main(String[] args) {

    }

}
