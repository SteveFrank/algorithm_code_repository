package com.algorithm.schedule;

import java.util.Random;

/**
 * @author frankq
 * @date 2021/9/7
 */
public class RR {

    //定义数组作为插槽，每个插槽中可以放入任务
    Integer[] integers;

    //length插槽的个数
    public RR(int length){
        integers = new Integer[length];
    }

    //将任务放入插槽
    public void addTask(int value){
        int slot = 0;
        //不停查找空的插槽
        while (true) {
            //发现空位，将当前任务放入
            if (integers[slot] == null){
                integers[slot] = value;
                System.out.println(String.format("------------------------->add task index=%s,value=%s",slot,value));
                break;
            }
            //如果当前位置有任务占用，看下一个位置
            slot++;
            //如果插槽遍历完还是没有空位置，那么从头开始再找，继续下一个轮回
            if (slot == integers.length){
                slot = 0;
            }
        }
    }
    //执行任务。轮询的策略就在这里
    public void execute(){
        //开启一个线程处理任务。在现实中可能有多个消费者来处理
        new Thread(new Runnable() {
            @Override
            public void run() {
                int index = 0;
                while (true) {
                    //指针轮询，如果到达尾部，下一步重新转向开头
                    // 数据物理结构是一个数组，逻辑上是一个环
                    if (index == integers.length){
                        index = 0;
                    }
                    //如果当前位置没有任务，轮询到下一个插槽
                    if (integers[index] == null){
                        index++;
                        continue;
                    }else{
                        //随机等待，表示模拟当前任务有一个执行时间
                        try {
                            Thread.currentThread().sleep(new Random().nextInt(1000));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //模拟任务执行的内容，也就是打印一下当前插槽和里面的值
                        System.out.println(String.format("execute index=%s,value=%s",index,integers[index]));
                        //执行完，将当前插槽清空，腾出位置来给后续任务使用
                        integers[index] = null;
                    }
                }
            }
        }).start();

    }

    public static void main(String[] args) {
        //测试开始，定义3个插槽
        RR rr = new RR(3);
        //唤起执行者线程，开始轮询
        rr.execute();
        //放置10个任务
        for (int i = 0; i < 10; i++) {
            rr.addTask(i);
        }

    }

}
