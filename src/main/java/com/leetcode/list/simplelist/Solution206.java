package com.leetcode.list.simplelist;

/**
 * 20200818
 * 206. 反转链表
 * * https://leetcode-cn.com/problems/reverse-linked-list/
 * @date 2020/8/18
 */
public class Solution206 {

    /**
     * 错误解法，当时思考的盲点
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     */
    public ListNode reverseList_bad_solution(ListNode head) {
        ListNode current = head;
        ListNode prev = head;
        while (head != null) {
            current = head;
            if (current.next != null) {
                prev.next = current;
                current.next = prev;
                prev = current;
            }
            head = head.next;
        }
        return prev;
    }

    /**
     * 效率最快，遍历一遍就可以得到结果
     * 1->2->3->4->5->NULL
     * 5->4->3->2->1->NULL
     */
    public ListNode reverseList_1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            // 交换
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * 递归的方案
     * 1->2->3->4->5->NULL
     * 5->4->3->2->1->NULL
     */
    public ListNode reverseList_2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList_2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }


    public static void main(String[] args) {

    }

}
