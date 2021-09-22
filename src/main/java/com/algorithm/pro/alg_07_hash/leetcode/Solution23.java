package com.algorithm.pro.alg_07_hash.leetcode;

import java.util.PriorityQueue;

/**
 * @author frankq
 * @date 2021/9/22
 */
public class Solution23 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeLists(ListNode[] lists) {
        // 特殊判断
        if (lists == null || lists.length < 1) {
            return null;
        }
        // 构建优先级队列
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.val < o2.val) {
                return -1;
            }
            if (o1.val > o2.val) {
                return 1;
            }
            return 0;
        });
        // 构造哨兵
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        // 将各个链表头节点加入队列
        for (ListNode head : lists) {
            if (head != null) {
                queue.offer(head);
            }
        }
        while (!queue.isEmpty()) {
            // 依次从队列中获取最小的值节点 queue.poll
            dummy.next = queue.poll();
            dummy = dummy.next;
            // 将各链表下一个节点加入队列
            if (dummy.next != null) {
                queue.offer(dummy.next);
            }
        }
        return result.next;
    }

    public static void main(String[] args) {

    }

}
