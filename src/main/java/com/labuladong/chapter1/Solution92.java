package com.labuladong.chapter1;

/**
 *  * public class ListNode {
 *  *     int val;
 *  *     ListNode next;
 *  *     ListNode() {}
 *  *     ListNode(int val) { this.val = val; }
 *  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 *  * }
 *
 * @author yangqian
 * @date 2021/3/8
 */
public class Solution92 {

    public static void main(String[] args) {

    }

    private ListNode successor = null;

    public ListNode reverseN(ListNode head, int n) {
        // base case
        if (n == 1) {
            // 记录下 n + 1个节点
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;

        head.next = successor;
        return last;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {

        // base case
        if (left == 1) {
            this.reverseN(head, right);
        }

        head.next = reverseBetween(head.next, left - 1, right - 1);

        return head;

    }

}
