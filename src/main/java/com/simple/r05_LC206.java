package com.simple;

/**
 * @author frankq
 * @date 2022/2/11
 */
public class r05_LC206 {

    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        // 双指针处理
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            // 没有走到尾节点
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }


    public ListNode reverseList2(ListNode head) {
        // 双指针处理
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }


}

class ListNode {
    int data;
    ListNode next;
    ListNode() {}
    ListNode(int data) { this.data = data; }
}
