package com.algorithm.schedule;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author frankq
 * @date 2021/9/7
 */
public class FCFS {

    public static void main(String[] args) throws InterruptedException {
        //阻塞队列，FCFS的基础
        final LinkedBlockingQueue<Task> queue = new LinkedBlockingQueue(5);
        //服务线程，任务由该线程获取和执行
        new Thread(new Runnable(){
            @Override
            public void run() {
                while (true) {
                    try {
                        queue.take().execute();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        //向队列中每隔100ms防入一个任务
        for (int i = 0; i < 5; i++) {
            System.out.println("add task:" + i);
            queue.put(new Task("task" + i,new Random().nextInt(1000)));
        }
    }

}
