package com.bytedance.demo20230807;

import java.util.*;

public class SolutionDemo {

    public static void main(String[] args) {

    }


    /**
     * 滑动窗口的处理方法
     * @param s
     * @return
     */
    private int solution3_lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0, right = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left ++;
            }
            set.add(s.charAt(right));
            right ++;
            max = Math.max(max, right - left);
        }
        return max;
    }

    /**
     * 是否是有效括号
     * @param s
     * @return
     */
    private boolean solution20_isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        char[] charArray = s.toCharArray();
        if (charArray.length % 2 != 0) {
            return false;
        }
        // 定义栈
        Stack<Character> stack = new Stack<>();
        for (char ch : charArray) {
            if (ch == '{') {
                stack.push('}');
            } else if (ch == '(') {
                stack.push(')');
            } else if (ch == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || ch != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

}

/**
 * 通过双向链表模拟实现LRU的功能
 */
class LRUCache {
    class LRUNode {
        int key;
        int value;
        LRUNode prev;
        LRUNode next;

        public LRUNode() {
        }

        public LRUNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    private Map<Integer, LRUNode> hashMap = new HashMap<>();

    // 定义容量大小
    private int capacity;
    // 定义size
    private int size;
    // 定义头 尾两个指针
    private LRUNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;

        // 用节点定义哨兵，方便统一处理
        this.head = new LRUNode();
        this.tail = new LRUNode();

        // 头尾指针连接，当前双向链表中没有数据
        head.next = tail;
        tail.prev = head;
    }
}

