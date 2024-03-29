package com.leetcode.list.newlist;

/**
 * 20200818
 * 21. 合并两个有序链表
 * * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * @date 2020/8/18
 */
public class Solution21 {

    /**
     * 解法1：考虑使用递归的方式求解
     * 最优解法
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        // 考虑两个边界情况
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }

    /**
     * 使用遍历的方式求解，但是花费的时间大于递归的方式
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while(l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    public static void main(String[] args) {

    }

}
