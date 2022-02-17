package com.simple;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author frankq
 * @date 2022/2/12
 */
public class r10_LC146 {

    public static void main(String[] args) {

    }

}

/**
 * 基于LinkedList的实现方法
 */
class LRUCacheWithLinkedList extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    // 构造方法
    public LRUCacheWithLinkedList(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    // 获取数据
    public int get(int key) {
        // 需要表示出当前数据已经使用
        return super.get(key);
    }

    // 将数据放入缓存
    public void put(int key, int value) {
        // 缓存容量如果达到上限需要进行呢删除操作
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
