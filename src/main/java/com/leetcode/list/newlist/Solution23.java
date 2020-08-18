package com.leetcode.list.newlist;


/**
 * 20200818
 * 23. 合并K个升序链表
 * * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * @date 2020/8/18
 */
public class Solution23 {

    /**
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     * 尝试遍历数组求解知道合并所有数组
     * 顺序合并属于比较暴力 可以进一步考虑分治求解
     */
    public ListNode mergeKLists_1(ListNode[] lists) {
        // 边界先覆盖
        if (lists.length == 0) {
            return null;
        }
        int i = 0;
        ListNode result = null;
        while (i < lists.length) {
            result = mergeTowList(result, lists[i]);
            i ++;
        }
        return result;
    }

    /**
     * 考虑使用分治求解方案
     */
    public ListNode mergeKLists_2(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    /**
     * 分支核心merge
     * @param list
     * @param left
     * @param right
     * @return
     */
    public ListNode merge(ListNode[] list, int left, int right) {
        if (left == right) {
            return list[left];
        }
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        return mergeTowList(merge(list, left, mid), merge(list, mid + 1, right));
    }


    /**
     * 合并两个列表
     */
    public ListNode mergeTowList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTowList(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTowList(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {

    }

}
