package com.algorithm.pro.alg_02_list.simple;

/**
 * @author frankq
 * @date 2021/9/15
 */
public interface List <E> {

    int size();

    boolean isEmpty();

    int indexOf(E o);

    boolean contains(E e);

    boolean add(E e);

    void add(int index, E element);

    E set(int index, E element);

    E get(int index);

    E remove(int index);

    void clear();

}
