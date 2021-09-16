package com.algorithm.pro.alg_04_stack.simple;

/**
 * 利用链表实现栈的时候要将链表的头部作为栈顶
 * @author frankq
 * @date 2021/9/16
 */
public class LinkedListStack<E> {

    /**
     * 单链表对象
     * @param <E>
     */
    private static class Node<E> {
        E val;
        Node<E> next;

        public Node(E val, Node<E> next) {
            this.val = val;
            this.next = next;
        }

    }

    private int size;
    private Node<E> head;

    public LinkedListStack() {
    }

    /**
     * 判断元素个数
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 判断栈是否为空
     * @return
     */
    public boolean empty() {
        return size == 0;
    }

    public E push(E item) {
        Node<E> newNode = new Node<>(item, head);
        head = newNode;
        size ++;
        return item;
    }

    public E peek() {
        if (head == null) {
            return null;
        }
        return head.val;
    }

    public E pop() {
        if (head == null) {
            return null;
        }
        Node<E> top = head;
        head = head.next;
        top.next = null;
        return top.val;
    }

    @Override
    public String toString() {
        return "LinkedListStack{" +
                "size=" + size +
                ", head=" + head +
                '}';
    }
}
