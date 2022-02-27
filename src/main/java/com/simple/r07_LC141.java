package com.simple;

/**
 * @author frankq
 * @date 2022/2/11
 */
public class r07_LC141 {

    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        // 特殊判断
        if (head == null || head.next == null) {
            return false;
        }
        // 定义快慢指针
        ListNode fast = head;
        ListNode slow = head;
        // 两个指针分别往下走
        do {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == null || fast.next == null) {
                return false;
            }
        } while (fast != slow);
        return true;
    }


    public static boolean hasCy(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        do {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == null || fast.next == null) {
                return false;
            }
        } while (fast != slow);
        return true;
    }









}
