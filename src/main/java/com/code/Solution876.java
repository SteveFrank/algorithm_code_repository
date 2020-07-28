package com.code;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution876 {

    public static ListNode middleNode(ListNode head) {
        if (head.next == null) {
            return head;
        }
        int index = 1;
        Map<Integer, ListNode> nodeMap = new HashMap<Integer, ListNode>(100);
        while (head != null) {
            nodeMap.put(index, head);
            head = head.next;
            if (head != null) {
                index ++;
            }
        }
        System.out.println(index);
        return nodeMap.get(index / 2 + 1);
    }

    public static void main(String[] args) {
        /**
         * 1、输入：[1,2,3,4,5]
         * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
         * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
         * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
         * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
         *
         * 2、输入：[1,2,3,4,5,6]
         * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
         * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
         */
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        node2.next = null;
        System.out.println(middleNode(node1).val);
    }

}

/**
 * 节点处理
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
