package com.algorithm.limit;

import java.util.LinkedHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author frankq
 * @date 2021/9/7
 */
public class Window1 {

    //计数器上限
    final int total = 6;
    //分多少片
    final int slice = 3;
    //窗口，3s长度，分3段
    LinkedHashMap<Long, AtomicInteger> linkedHashMap = new LinkedHashMap<>(slice);

    ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

    private Long getKey(){
        return System.currentTimeMillis()/5000;
    }

    public Window1(){
        Long key = getKey();
        for (int i = 0; i < slice; i++) {
            this.linkedHashMap.put(key-i*5,new AtomicInteger(0));
        }
        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(linkedHashMap);
                Long key = getKey();
                linkedHashMap.remove(key+(1-slice)*5);
                linkedHashMap.put(key,new AtomicInteger(0));
            }
        },5000,5000, TimeUnit.MILLISECONDS);
    }

    public boolean checkCurrentSlice(){
        long key = System.currentTimeMillis()/1000;
        AtomicInteger integer = linkedHashMap.get(key);
        if (integer != null){
            return integer.get() <= total;
        }
        //默认允许访问
        return true;
    }

    public boolean checkAllCount(){
        return linkedHashMap.values().stream().mapToInt(value -> value.get()).sum()  <= total;
    }

    public void req(){
        if (checkCurrentSlice() && checkAllCount()){
            Long key = getKey();
            System.out.println(linkedHashMap);
            System.out.println(key);
            linkedHashMap.get(key).incrementAndGet();
            System.out.println("ok!");
        }else {
            System.out.println(linkedHashMap);
            System.out.println("reject!");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Window1 window = new Window1();
        Thread.sleep(3000);
        for (int i = 0; i < 20; i++) {
            Thread.sleep(300);
            window.req();
        }
    }

}
