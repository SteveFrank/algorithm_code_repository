package com.simple;

import java.util.HashMap;

/**
 * @author frankq
 * @date 2022/2/17
 */
public class r10_LC146_custom {

    public static void main(String[] args) {

    }

}

/**
 * 自定义实现HashMap 双向链表的缓存机制
 */
class LRUCache {
    /**
     * 定义双向链表的节点类
     */
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        public Node() {}
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    // 定义哈希表
    private HashMap<Integer, Node> hashMap = new HashMap<>();
    // 定义属性
    private int capacity;
    private int size;
    // 定义头尾指针
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;

        // 用节点定义哨兵，方便统一处理
        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;
    }

    // get方法
    public int get(int key) {
        // 从hash表中查找key，如果不存在的话就返回-1
        Node node = hashMap.get(key);
        if (node == null) {
            return -1;
        }
        // 如果存在则移动到链表末尾
        moveToTail(node);
        return node.value;
    }

    // put 操作
    public void put(int key, int value) {
        // 同样现在哈希表中查找key
        Node node = hashMap.get(key);
        // 如果key存在，修改value 并且移动到末尾
        if (node != null) {
            node.value = value;
            // 移动到链表尾
            moveToTail(node);
        } else {
            // 如果不存在 需要创建新的节点，插入到末尾
            Node newNode = new Node(key, value);
            hashMap.put(key, newNode);
            // 添加到链表尾
            addToTail(newNode);
            size ++;
            // 如果超出了容量，需要删除链表的头节点
            if (size > capacity) {
                Node head = removeHead();
                hashMap.remove(head.key);
                size--;
            }
        }
    }

    // 移动节点到末尾
    private void moveToTail(Node node) {
        // 移除节点
        removeNode(node);
        // 添加节点到末尾
        addToTail(node);
    }

    // 删除节点中的某一个节点
    private void removeNode(Node node) {
        // 跳过当前node
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 在链表末尾增加一个节点
    private void addToTail(Node node) {
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }

    // 删除头节点
    private Node removeHead() {
        Node realHead = head.next;
        removeNode(realHead);
        return realHead;
    }

}
