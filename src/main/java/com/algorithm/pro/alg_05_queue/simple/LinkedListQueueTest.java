package com.algorithm.pro.alg_05_queue.simple;

/**
 * @author frankq
 * @date 2021/9/16
 */
public class LinkedListQueueTest {

    public static void main(String[] args) {
        LinkedListQueue<String> queue = new LinkedListQueue<>();
        queue.offer("aa");
        queue.offer("bb");
        queue.offer("cc");
        queue.offer("dd");
        queue.offer("ee");

        System.out.println(queue.poll());

        System.out.println(queue);
    }

}
