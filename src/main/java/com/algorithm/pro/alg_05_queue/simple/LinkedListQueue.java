package com.algorithm.pro.alg_05_queue.simple;

import com.algorithm.pro.alg_04_stack.simple.LinkedListStack;

import java.util.NoSuchElementException;

/**
 * @author frankq
 * @date 2021/9/16
 */
public class LinkedListQueue<E> implements Queue<E> {

    private static class Node<E> {
        E val;
        Node<E> next;

        public Node(E val) {
            this.val = val;
        }

        public Node(E val, Node<E> next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 队列长度
     */
    private int size;
    /**
     * 队列头
     */
    private Node<E> head;
    /**
     * 队列尾
     */
    private Node<E> tail;

    public LinkedListQueue() {
    }

    @Override
    public boolean add(E e) {
        linkList(e);
        return true;
    }

    @Override
    public boolean offer(E e) {
        linkList(e);
        return true;
    }

    private void linkList(E e) {
        Node<E> t = tail;
        Node<E> newNode = new Node<>(e, null);
        if (t == null) {
            head = newNode;
        } else {
            t.next = newNode;
        }
        size ++;
    }

    @Override
    public E remove() {
        if (size == 0) {
            throw new NoSuchElementException("队列为空!");
        }
        Node<E> h = unlinkHead();
        return h.val;
    }

    @Override
    public E poll() {
        if (size == 0) {
            return null;
        }
        Node<E> h = unlinkHead();
        return h.val;
    }

    private Node<E> unlinkHead() {
        Node<E> h = head;
        head = h.next;
        h.next = null;
        size --;
        return h;
    }

    @Override
    public E element() {
        if (size == 0) {
            throw new NoSuchElementException("队列为空!");
        }
        Node<E> h = head;
        return h.val;
    }

    @Override
    public E peek() {
        if (size == 0) {
            return null;
        }
        Node<E> h = head;
        return h.val;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return "LinkedListQueue{" +
                "size=" + size +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }
}
