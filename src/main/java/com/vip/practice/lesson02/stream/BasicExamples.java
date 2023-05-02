package com.vip.practice.lesson02.stream;

import org.junit.Test;

import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author frankq
 * @date 2023/5/2
 */
public class BasicExamples {

    @Test
    public void test_mapFilter() {
        final Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6)
                .map(Object::toString)
                .map(x -> x + x)
                .map(x -> x + x + x)
                .map(Integer::parseInt);
        // lambda expression
        System.out.println(stream);
    }

    @Test
    public void test_mapFilterReduce() {
        final Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6)
                .map(Object::toString)
                .map(x -> x + x)
                .map(x -> x + x + x)
                .map(Integer::parseInt);
        // lambda expression
        System.out.println(stream);
    }

    @Test
    public void test_parallel() {
        final Random random = new Random();
        final List<Integer> result = IntStream.range(0, 1_000_000)
                .map(x -> random.nextInt(10_000_000))
                .boxed()
                .collect(Collectors.toList());

        System.out.println(result.stream().max((a, b) -> a - b));
        System.out.println(result.parallelStream().max((a, b) -> a - b));
    }

}
