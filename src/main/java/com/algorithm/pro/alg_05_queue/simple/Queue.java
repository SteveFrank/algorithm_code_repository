package com.algorithm.pro.alg_05_queue.simple;

/**
 * @author frankq
 * @date 2021/9/16
 */
public interface Queue<E> {

    /**
     * 在不违反容量限制的情况下立即将指定的元素插入队列，成功时会立即返回true
     * 如果当时没有空间，则会抛出IllegalStateException异常
     */
    boolean add(E e);

    /**
     * 在不违反容量限制的情况下立即将指定的元素插入到此队列中，成功的时候立即返回true
     */
    boolean offer(E e);

    /**
     * 检索并删除次队列的头，如果队列为空抛出NoSuchElementException
     */
    E remove();

    /**
     * 检索并删除此队列的头，如果为空，则返回null
     */
    E poll();

    /**
     * 检索但是不删除此队列的头，如果队列为空，则抛出异常
     */
    E element();

    /**
     * 检索但是不删除此队列的头，如果队列为空，则返回null
     */
    E peek();

    /**
     * 返回队列中元素个数
     */
    int size();

    /**
     * 判断队列是否为空
     */
    boolean isEmpty();

}
