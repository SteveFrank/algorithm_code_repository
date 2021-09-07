package com.algorithm.schedule;

/**
 * @author frankq
 * @date 2021/9/7
 */
public class Task {
    //任务名称
    private String name;
    //任务提交的时间
    private Long addTime;
    //任务的执行时间
    private int servTime;
    //任务优先级
    private int level;

    public Task(String name, int servTime) {
        this.name = name;
        this.servTime = servTime;
        this.addTime = System.currentTimeMillis();
    }
    public Task(String name, int servTime,int level) {
        this.name = name;
        this.servTime = servTime;
        this.level = level;
        this.addTime = System.currentTimeMillis();
    }

    public void execute() {
        try {
            // ！重点：执行时睡眠，表示该任务耗时servTime毫秒
            Thread.sleep(servTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(
                String.format("execute:name=%s,level=%s,addTime=%s,servTime=%s",
                        name,level, addTime, servTime));
    }
}
