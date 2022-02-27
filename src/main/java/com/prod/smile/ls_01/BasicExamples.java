package com.prod.smile.ls_01;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author frankq
 * @date 2022/2/27
 */
public class BasicExamples {

    public static void main(String[] args) {
//        test_mapFilter();
//        test_mapFilterReduce();

        test_parallel();
    }

    public static void test_mapFilter() {
        Stream.of(1,2,3,4,5,6)
                .map(x -> x.toString())
                .map(x -> x + x)
                .map(x -> x + x + x)
                .map(Integer::parseInt)
                .forEach(x -> {
                    System.out.println(x);
                });
    }

    public static void test_mapFilterReduce() {
        // Monad
        final Optional<Integer> reduce = Stream.of(1, 2, 3, 4, 5, 6)
                .map(x -> x * x)
                .filter(x -> x < 20)
                .reduce(Math::max);
        // Optional 更加安全的integer, 将这个流包装了起来，避免了异常的造成
        System.out.println(reduce);

        // or else
        final Integer integer = Stream.of(1, 2, 3, 4, 5, 6)
                .map(x -> x * x)
                .filter(x -> x < 20)
                .reduce(Math::max).orElse(0);
        System.out.println(integer);

        // 排序
        final Stream<Integer> sorted = Stream.of(1, 3, 5, 2, 4, 9, 0, 7).sorted();
        sorted.forEach(System.out::println);

        // flatMap
        // String -> Stream<R>
        // IntStream != Stream<int>
        Stream.of("My", "Mine")
                .flatMap(str -> str.chars().mapToObj(i -> (char)i))
                .collect(Collectors.toSet())
                .forEach(System.out::println);
    }

    public static void test_parallel() {
        var r = new Random();
        final List<Integer> list = IntStream.range(0, 1_000_00)
                .map(x -> r.nextInt(10_000_00))
                .boxed()
                .collect(Collectors.toList());
        // 计算最大值
        var t0 = System.currentTimeMillis();
        System.out.println(list.stream().max(Comparator.comparingInt(a -> a)));
        System.out.println("time:" + (System.currentTimeMillis() - t0));

        // 8 核
        System.out.println(Runtime.getRuntime().availableProcessors());

        var t1 = System.currentTimeMillis();
        final Optional<Integer> max = list.parallelStream().max(Comparator.comparingInt(a -> a));
        System.out.println("time:" + (System.currentTimeMillis() - t1));

        var t2 = System.currentTimeMillis();
        var pool = new ForkJoinPool(2);
        final ForkJoinTask<Optional<Integer>> result = pool.submit(
                () -> list.parallelStream().max(Comparator.comparingInt(a -> a)));
        System.out.println("time:" + (System.currentTimeMillis() - t2));


    }

}
