package com.leetcode.list.simplelist;

/**
 * 20200820
 * 61. 旋转链表
 * * https://leetcode-cn.com/problems/rotate-list/
 * @date 2020/8/20
 */
public class Solution61 {

    public ListNode rotateRight(ListNode head, int k) {
        // 先考虑覆盖基础用例
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        // 闭环
        ListNode oldTail = head;
        int nodeCount;
        for (nodeCount = 1; oldTail.next != null; nodeCount ++) {
            oldTail = oldTail.next;
        }
        oldTail.next = head;

        // 获取旋转后的新环
        ListNode newTail = head;
        for (int i = 0; i < nodeCount - k % nodeCount - 1; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;

        newTail.next = null;

        return newHead;
    }

    public static void main(String[] args) {
    }

}
