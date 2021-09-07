package com.algorithm.schedule;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * @author frankq
 * @date 2021/9/7
 */
public class SJF {

    public static void main(String[] args) throws InterruptedException {
        //有序Map，将服务时间作为key排序
        final TreeMap<Integer,Task> treeMap = new TreeMap();

        //向队列中放入5个任务
        for (int i = 0; i < 5; i++) {
            System.out.println("add task:"+i);
            int servTime = new Random().nextInt(1000);
            //注意，key是servTime，即执行预估时间
            treeMap.put(servTime,new Task("task"+i,servTime));
        }

        //服务线程，任务由该线程获取和执行
        new Thread(new Runnable(){
            @Override
            public void run() {
                while (true) {
                    try {
                        //有序Map中，服务时间短的，置于顶部，那么自然就会优先被取出
                        Map.Entry<Integer,Task> entry = treeMap.pollFirstEntry();
                        if (entry == null){
                            Thread.currentThread().sleep(100);
                        }else {
                            entry.getValue().execute();
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}
