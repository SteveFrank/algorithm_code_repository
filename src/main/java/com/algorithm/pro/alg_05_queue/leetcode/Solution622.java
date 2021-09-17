package com.algorithm.pro.alg_05_queue.leetcode;

/**
 * 622 设计循环队列
 * https://leetcode-cn.com/problems/design-circular-queue/
 * @author frankq
 * @date 2021/9/16
 */
public class Solution622 {

    private static class MyCircularQueue {

        private int capacity;
        /**
         * 内容数组
         */
        private int[] elementData;
        /**
         * 头指针
         */
        private int front;
        /**
         * 尾指针
         */
        private int rear;

        public MyCircularQueue(int k) {
            this.capacity = k + 1;
            elementData = new int[k+1];
            front = rear = 0;
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            elementData[rear] = value;
            rear = (rear + 1) % capacity;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            front = (front + 1) % capacity;
            return true;
        }

        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            return elementData[front];
        }

        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            return elementData[(rear + capacity - 1) % capacity];
        }

        public boolean isEmpty() {
            return front == rear;
        }

        public boolean isFull() {
            return front == (rear + 1) % capacity;
        }
    }

    public static void main(String[] args) {

    }

}
