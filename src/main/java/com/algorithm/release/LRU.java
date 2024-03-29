package com.algorithm.release;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author frankq
 * @date 2021/9/7
 */
public class LRU {

    LinkedList<Integer> lru = new LinkedList<Integer>();
    int size = 3;

    //添加元素
    public void add(int i){
        lru.addFirst(i);
        if (lru.size() > size){
            lru.removeLast();
        }
        print();
    }

    //缓存命中
    public void read(int i){
        Iterator<Integer> iterator = lru.iterator();
        int index = 0;
        while (iterator.hasNext()){
            int j = iterator.next();
            if (i == j){
                System.out.println("find it!");
                lru.remove(index);
                lru.addFirst(j);
                print();
                return ;
            }
            index++;
        }
        System.out.println("not found!");
        print();
    }

    //打印缓存
    public void print(){
        System.out.println(this.lru);
    }

    //测试
    public static void main(String[] args) {
        LRU lru = new LRU();
        System.out.println("add 1-3:");
        lru.add(1);
        lru.add(2);
        lru.add(3);
        System.out.println("add 4:");
        lru.add(4);
        System.out.println("read 2:");
        lru.read(2);
        System.out.println("read 100:");
        lru.read(100);
        System.out.println("add 5:");
        lru.add(5);
    }

}
