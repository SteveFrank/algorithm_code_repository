package com.leetcode.list.simplelist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 20200818
 * 25. K 个一组翻转链表
 * * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * @date 2020/8/18
 */
public class Solution25 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);
            line = in.readLine();
            int k = Integer.parseInt(line);

            ListNode ret = new Solution25().reverseKGroup(head, k);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }

    /**
     * 给你这个链表：1->2->3->4->5
     * 当k= 2 时，应当返回: 2->1->4->3->5
     * 当k= 3 时，应当返回: 3->2->1->4->5
     */
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

    public ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode tempNextNode = current.next;
            current.next = prev;
            prev = current;
            current = tempNextNode;
        }
        return prev;
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
}
