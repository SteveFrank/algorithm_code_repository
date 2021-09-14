package com.algorithm.pro.array.simple;

/**
 * @author frankq
 * @date 2021/9/14
 */
public interface List {

    int size();

    boolean isEmpty();

    /**
     * 查询元素的下标
     */
    int indexOf(int o);

    /**
     * 判断是否包含某个特定的元素
     */
    boolean contains(int e);

    /**
     * 将元素添加到容器末尾
     */
    boolean add(int e);

    /**
     * 指定位置添加数据
     */
    void add(int index, int element);

    /**
     * 指定位置替换数据
     */
    int set(int index, int element);

    /**
     * 获取指定位置元素
     */
    int get(int index);

    int remove(int index);

    void clear();

}
