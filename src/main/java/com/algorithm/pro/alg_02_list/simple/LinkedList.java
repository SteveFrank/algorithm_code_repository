package com.algorithm.pro.alg_02_list.simple;

/**
 * @author frankq
 * @date 2021/9/15
 */
public class LinkedList<E> implements List<E> {

    /**
     * 定义私有的节点对象
     */
    private static class Node<E> {
        E val;
        Node<E> prev;
        Node<E> next;
        /**
         * 定义构造
         */
        public Node(Node<E> prev, E val, Node<E> next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * 定义容器中的元素个数
     */
    private int size;
    /**
     * 定义链表的头节点
     */
    private Node<E> first;
    /**
     * 定义链表的尾节点
     */
    private Node<E> last;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int indexOf(E o) {
        int index = 0;
        // 分情况 进行处理
        if (null == o) {
            // 为 null 使用等号判断即可
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.val == null) {
                    return index;
                }
                index ++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.val)) {
                    return index;
                }
                index ++;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(E e) {
        return indexOf(e) != -1;
    }

    @Override
    public boolean add(E e) {
        // 添加是将元素值添加到链表尾部
        linkLast(e);
        return true;
    }

    private void linkLast(E e) {
        Node<E> l = last;
        Node<E> newNode = new Node<E>(l, e, null);
        last = newNode;
        if (l == null) {
            // 第一次添加元素
            first = newNode;
        } else {
            l.next = newNode;
        }
        size ++;
    }

    @Override
    public void add(int index, E element) {
        // 检查索引
        checkIndex(index);
        if (index == size) {
            linkLast(element);
        } else {
            // 如果不等于长度，则在链表中添加元素
            linkBefore(element, node(index));
        }
    }

    private void linkBefore(E element, Node<E> node) {
        Node<E> prev = node.prev;
        Node<E> newNode = new Node<E>(prev, element, node);
        node.prev = newNode;
        if (prev == null) {
            first = newNode;
        } else {
            prev.next = newNode;
        }
        size ++;
    }

    private Node<E> node(int index) {
        // 折半查找
        if (index < (size >> 1)) {
            // 从头节点开始查找
            Node<E> f = first;
            for (int i = 0; i < index; i++) {
                f = f.next;
            }
            return f;
        } else {
            // 从尾部节点开始查找
            Node<E> l = last;
            for (int i = size - 1; i > index; i --) {
                l = l.prev;
            }
            return l;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index " + index + ", size = " + size);
        }
    }

    @Override
    public E set(int index, E element) {
        isElementIndex(index);
        Node<E> oldNode = node(index);
        E oldVal = oldNode.val;
        oldNode.val = element;
        return oldVal;
    }

    @Override
    public E get(int index) {
        isElementIndex(index);
        return node(index).val;
    }

    private void isElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index = " + index + ", size = " + size);
        }
    }

    @Override
    public E remove(int index) {
        isElementIndex(index);
        Node<E> node = node(index);
        return unlink(node);
    }

    private E unlink(Node<E> node) {
        Node<E> prev = node.prev;
        Node<E> next = node.next;
        E val = node.val;
        node.val = null;

        // node 是头节点
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        // node 是尾节点
        if(next == null) {
            last = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }
        size --;
        return val;

    }

    @Override
    public void clear() {
        for (Node l = first; l != null; ) {
            Node next = l.next;
            l.val = null;
            l.prev = null;
            l.next = null;
            l = next;
        }
        first = last = null;
        size = 0;
    }

    @Override
    public String toString() {
        // 输出 1 ‐> 2 ‐> Null格式的数据
        StringBuilder stringBuilder = new StringBuilder();
        for(Node<E> l = first; l != null; l = l.next){
            stringBuilder.append(l.val).append("‐>");
        }
        stringBuilder.append("Null");
        return stringBuilder.toString();
    }
}
