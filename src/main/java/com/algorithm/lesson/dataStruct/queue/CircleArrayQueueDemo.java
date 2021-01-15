package com.algorithm.lesson.dataStruct.queue;

import java.util.Scanner;

/**
 * @author yangqian
 * @date 2021/1/15
 */
public class CircleArrayQueueDemo {

    public static void main(String[] args) {
        System.out.println("测试数据模拟环形队列");
        // 测试数据模拟环形队列
        // 设置4 其实只有3
        final CircleArrayQueue queue = new CircleArrayQueue(4);
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
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数据");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
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
 *
 * PS: 环形队列数据结构中的相关操作，有点儿类似于追及问题
 *
 * 使用数组模拟队列
 */
class CircleArrayQueue {
    /**
     * 数组的最大容量
     */
    private int maxSize;
    /**
     * front 变量的含义做一个调整：
     *  -> front 就指向队列的第一个元素, 也就是说 arr[front] 就是队列的第一个元素
     * front 的初始值 = 0
     */
    private int front;
    /**
     * rear 变量的含义做一个调整：
     *  -> rear 指向队列的最后一个元素的后一个位置. 因为希望空出一个空间做为约定.
     * rear 的初始值 = 0
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
    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    /**
     * 队列是否满
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
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
        // 直接将数据加入
        arr[rear] = n;
        // 将rear后移，这里必须考虑取模
        rear = (rear + 1) % maxSize;
    }

    /**
     * 获取队列的数据，出队列
     */
    public int getQueue() {
        // 判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空,无法取数据");
        }
        // 分析出front是指向队列的第一个元素
        // 1、先把 front 对应的值保存到一个临时的变量
        // 2、将 front 后移，考虑取模
        // 3、将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    /**
     * 显示队列所有的数量
     */
    public void showQueue() {
        // 判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空,无法取数据");
        }
        // 从front开始遍历
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    /**
     * 求出当前队列有效数据的个数
     * @return
     */
    public int size() {
        return (rear + maxSize - front) % maxSize;
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
        return arr[front];
    }

}
