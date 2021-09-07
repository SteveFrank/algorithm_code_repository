package com.algorithm.limit;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author frankq
 * @date 2021/9/7
 */
public class Counter {

    public static void main(String[] args) {
        //计数器，这里用信号量实现
        final Semaphore semaphore = new Semaphore(3);
        //定时器，到点清零
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                semaphore.release(3);
            }
        },3000,3000,TimeUnit.MILLISECONDS);

        //模拟无限请求从天而降降临
        while (true) {
            try {
                //判断计数器
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //如果准许响应，打印一个ok
            System.out.println("ok");
        }

    }

}
