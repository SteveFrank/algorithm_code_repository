package com.vip.practice.lesson02.monad;

import java.util.stream.Stream;

/**
 *
 * Event 是上下文的容器
 * T 是我们真实要做的事情
 *
 * @author frankq
 * @date 2023/5/2
 */
public class Event<T> {

    T data;

    public Event(T data) {
        this.data = data;
    }

    static class EventData {
        private Integer id;
        private String msg;

        public EventData(Integer id, String msg) {
            this.id = id;
            this.msg = msg;
        }

        @Override
        public String toString() {
            return "EventData{" + "id=" + id + ", msg='" + msg + "'\''}'";
        }
    }

    static class Transforms {
        static EventData transform(Integer id) {
            return switch (id) {
                case 0 -> new EventData(id, "start");
                case 1 -> new EventData(id, "Running");
                case 2 -> new EventData(id, "Done");
                case 3 -> new EventData(id, "Fail");
                default -> new EventData(id, "Error");
            };
        }
    }

    /**
     * 传入一个A 返回一个B
     */
    @FunctionalInterface
    interface FN<A, B> {
        B apply(A a);
    }

    <B> Event<?> map(FN<T, B> f) {
        // 类型的转换
        return new Event<B>(f.apply(this.data));
    }

    public static void main(String[] args) {
        Stream<Event<Integer>> s = Stream.of(
                new Event<>(1),
                new Event<>(2),
                new Event<>(0),
                new Event<>(10)
        );
        s.map(event -> event.map(Transforms::transform))
                .forEach(e -> System.out.println(e.data));
    }

}
