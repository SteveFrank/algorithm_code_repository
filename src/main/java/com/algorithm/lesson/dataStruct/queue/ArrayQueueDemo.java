package com.algorithm.lesson.dataStruct.queue;

import java.util.Scanner;

/**
 * @author yangqian
 * @date 2021/1/15
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {

        final ArrayQueue arrayQueue = new ArrayQueue(3);
        // 接收用户的输入
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        // 输出菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");

            // 接收一个字符
            key = scanner.next().charAt(0);

            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数据");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }

        }

    }

}


/**
 * 使用数组模拟队列
 */
class ArrayQueue {
    /**
     * 数组的最大容量
     */
    private int maxSize;
    /**
     * 队列头
     */
    private int front;
    /**
     * 队列尾
     */
    private int rear;
    /**
     * 该数据用于存放数据，模拟队列
     */
    private int[] arr;

    /**
     * 创建队列构造器
     * @param maxSize 最大长度
     */
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        // 初始指向队列的头部，没有数据的时候指向队列头的前一个位置
        front = -1;
        // 指向队列尾，指向队列尾的数据（即就是队列的最后一个数据）
        rear  = -1;
    }

    /**
     * 队列是否满
     * @return
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 添加数据到队列中
     * @param n
     */
    public void addQueue(int n) {
        // 判断队列是否满
        if (isFull()) {
            System.out.println("队列满，不可以加入数据");
            return;
        }
        // 让rear后移
        rear ++;
        arr[rear] = n;
    }

    /**
     * 获取队列的数据，出队列
     */
    public int getQueue() {
        // 判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空,无法取数据");
        }
        // front后移
        front ++;
        return arr[front];
    }

    /**
     * 显示队列所有的数量
     */
    public void showQueue() {
        // 判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空,无法取数据");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    /**
     * 显示队列的头部数据，注意此处不是取出数据
     * @return
     */
    public int headQueue() {
        // 判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空,无法取数据");
        }
        return arr[front + 1];
    }

}

