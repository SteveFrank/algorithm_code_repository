package com.labuladong.chapter1;

/**
 * @author yangqian
 * @date 2021/3/8
 */
public class Demo {

    /**
     * 反转整个链表的递归操作
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next = null;
        return last;
    }

    /**
     * 将链表的前 n 个节点反转 （n <= 链表长度）
     * @param node
     * @return
     */
    public ListNode successor = null;

    public ListNode reverseN(ListNode head, int n) {
        // 反转以head为起点的n个节点，返回新的头节点
        if (n == 1) {
            // 记录第 n+1
            successor = head.next;
            return head;
        }
        // 以 head.next 作为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        // 反转之后的head节点和后面的节点连在一起
        head.next = successor;
        return last;
    }

    /**
     * 反转区间内的链表
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 反转的起点出发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

}
