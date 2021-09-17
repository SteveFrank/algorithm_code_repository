package com.algorithm.pro.alg_05_queue.leetcode;

/**
 * 设计循环的双端队列
 * https://leetcode-cn.com/problems/design-circular-deque/
 * @author frankq
 * @date 2021/9/17
 */
public class Solution641 {

    private static class MyCircularDeque {

        int capacity;
        int[] elementData;
        int front;
        int rear;

        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            this.capacity = k + 1;
            elementData = new int[capacity];
            front = rear = 0;
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            front = (front - 1 + capacity) % capacity;
            elementData[front] = value;
            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            elementData[rear] = value;
            rear = (rear + 1) % capacity;
            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            front = (front + 1) % capacity;
            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            rear = (rear - 1 + capacity) % capacity;
            return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return elementData[front];
        }

        /** Get the last item from the deque. */
        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            return elementData[(rear - 1 + capacity) % capacity];
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return front == rear;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return front == (rear + 1) % capacity;
        }
    }

}
