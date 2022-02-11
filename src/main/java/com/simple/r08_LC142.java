package com.simple;

/**
 * @author frankq
 * @date 2022/2/11
 */
public class r08_LC142 {

    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        // 相遇的点就是该节点
        ListNode fast = head;
        ListNode slow = head;
        do {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == null || fast.next == null) {
                return null;
            }
        } while(fast != slow);
        ListNode ptr = head;
        // 同时开始起步，让他们在环相遇
        while (ptr != fast) {
            ptr = ptr.next;
            fast = fast.next;
        }
        return ptr;
    }

}
