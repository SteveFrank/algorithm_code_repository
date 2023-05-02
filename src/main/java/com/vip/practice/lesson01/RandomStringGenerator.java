package com.vip.practice.lesson01;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 请用Iterable实现一个随机序列产生器?
 * @author frankq
 * @date 2023/5/2
 */
public class RandomStringGenerator<T> implements Iterable<T> {

    private final List<T> list;

    public RandomStringGenerator(List<T> list) {
        this.list = list;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public T next() {
                return list.get((int) (list.size() * Math.random()));
            }
        };
    }

    public static void main(String[] args) {
        final List<String> list = Arrays.asList("List", "Tree", "Array");
        final RandomStringGenerator<String> randomStringGenerator = new RandomStringGenerator<>(list);
        for (int i = 0; i < 100; i++) {
            final Iterator<String> iterator = randomStringGenerator.iterator();
            final String next = iterator.next();
            System.out.println(next);
        }
    }

}
