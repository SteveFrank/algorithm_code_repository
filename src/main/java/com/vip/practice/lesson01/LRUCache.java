package com.vip.practice.lesson01;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author frankq
 * @date 2023/5/2
 */
public class LRUCache<K, V> implements Iterable<K> {

    private int MAX = 3;
    private LinkedHashMap<K, V> cache = new LinkedHashMap<>();

    public void cache(K key, V value) {
        if (cache.containsKey(key)) {
            cache.remove(key);
        }
        if (cache.size() >= MAX) {
            final Iterator<K> iterator = cache.keySet().iterator();
            final K first = iterator.next();
            cache.remove(first);
        }
        cache.put(key, value);
    }

    @Override
    public Iterator<K> iterator() {

        final Iterator<K> iterator = cache.keySet().iterator();

        return new Iterator<K>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public K next() {
                return iterator.next();
            }
        };
    }

    public static void main(String[] args) {
        final LRUCache<String, Integer> lruCache = new LRUCache<>();
        lruCache.cache("A", 1);
        lruCache.cache("B", 2);
        lruCache.cache("C", 3);
        lruCache.cache("D", 4);
        lruCache.cache("C", 10);
        System.out.println("leave <-" + StreamSupport
                .stream(lruCache.spliterator(), false)
                .map(String::toString).collect(Collectors.joining("<-")));
    }

}
