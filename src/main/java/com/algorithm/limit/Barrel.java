package com.algorithm.limit;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author frankq
 * @date 2021/9/7
 */
public class Barrel {

    public static void main(String[] args) {
        // 桶，用阻塞队列实现，容量为3
        final LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(3);
        // 定时器，相当于服务的窗口，2s处理一个
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.scheduleAtFixedRate(() -> {
            int value = queue.poll();
            System.out.println("处理:" + value);
        }, 2000, 2000, TimeUnit.MILLISECONDS);

        // 无数个请求，i可以理解为请求
        int i=0;
        while (true) {
            i++;
            try {
                System.out.println("put:"+i);
                //如果是put，会一直等待桶中有空闲位置，不会丢弃
                queue.put(i);
                //等待1s如果进不了桶，就溢出丢弃
                queue.offer(i,1000,TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
