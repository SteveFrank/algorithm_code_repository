package com.simple;

/**
 * @author frankq
 * @date 2022/4/12
 */
public class r28_LC25 {

    public static void main(String[] args) {

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode current = head;
        int i = k;
        while (i > 0 && current != null) {
            current = current.next;
            i --;
        }
        if (i > 0) {
            return head;
        }
        ListNode pre = reverseKGroup(current, k);
        current = head;
        i = k;
        while (i > 0) {
            ListNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
            i --;
        }
        return pre;
    }

}
