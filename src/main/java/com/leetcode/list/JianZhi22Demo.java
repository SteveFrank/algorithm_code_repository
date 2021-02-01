package com.leetcode.list;

import com.leetcode.list.simplelist.ListNode;

/**
 *
 * 输入一个链表，输出该链表中倒数第k个节点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。
 * 这个链表的倒数第3个节点是值为4的节点。
 *
 */
public class JianZhi22Demo {

    /**
     * 基础解法
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd1(ListNode head, int k) {
        if (head.next == null) {
            return head;
        }
        int length = 1;
        ListNode cur = head;
        while (cur.next != null) {
            length ++;
            cur = cur.next;
        }
        System.out.println(length);
        cur = head;
        int index = length - k;
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }

    /**
     * 1、2、3、4、5、6
     * 快满指针法
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd2(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }
        ListNode pfast = head;
        ListNode pslow = head;
        for (int i = 0; i <= k - 1; i++) {
            if (pfast.next != null) {
                pfast = pfast.next;
            } else {
                return null;
            }
        }
        while (pfast.next != null) {
            pfast = pfast.next;
            pslow = pslow.next;
        }
        return pslow;
    }

    public static ListNode getKthFromEnd3(ListNode head, int k) {
        if (head.next == null) {
            return head;
        }
        ListNode fastNode = head;
        ListNode slowNode = head;
        while(k > 0) {
            fastNode = fastNode.next;
            k--;
        }
        while (fastNode != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode result = getKthFromEnd3(node1, 3);
        System.out.println(result);
    }

}
