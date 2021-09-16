package com.algorithm.pro.alg_04_stack.simple;

import java.util.Arrays;

/**
 * @author frankq
 * @date 2021/9/16
 */
public class Stack<E> {

    private Object[] elementData;
    private int elementCount;

    public Stack(int elementCount) {
        this.elementData = new Object[elementCount];
    }

    public Stack() {
        this(10);
    }

    public int size() {
        return elementCount;
    }

    public boolean empty() {
        return elementCount == 0;
    }

    /**
     * 压栈操作
     * @param item 被存入的压栈元素
     */
    public E push(E item) {
        // 确保容量足够
        ensureCapacity(elementCount + 1);
        this.elementData[elementCount ++] = item;
        return item;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > this.elementData.length) {
            // 如果最小的长度已经不够，则需要进行增长
            grow(minCapacity);
        }
    }

    private void grow(int minCapacity) {
        int oldCapacity = this.elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity < minCapacity) {
            newCapacity = minCapacity;
        }
        // 借助数组拷贝工具进行拷贝
        this.elementData = Arrays.copyOf(this.elementData, newCapacity);
    }

    /**
     * 获取栈顶元素
     */
    public E peek() {
        // 索引是否正确
        int len = size();
        if (len == 0) {
            return null;
        }
        return elementAt(len - 1);
    }

    private E elementAt(int index) {
        if (index >= this.elementCount || index < 0) {
            throw new IndexOutOfBoundsException("index = " + index + ", elementCount = " + this.elementCount);
        }
        return (E) this.elementData[index];
    }

    public E pop() {
        E peek = peek();
        int len = size();
        // 移除栈顶元素
        removeElementAt(len - 1);
        return peek;
    }

    private void removeElementAt(int index) {
        if (index >= this.elementCount || index < 0) {
            throw new IndexOutOfBoundsException("index = " + index + ", elementCount = " + this.elementCount);
        }
        if (index < this.elementCount - 1) {
            System.arraycopy(
                    this.elementData, index + 1,
                    this.elementData, index,
                    this.elementCount - index - 1);
        }
        // 栈中元素减去1
        elementCount --;
        elementData[elementCount] = null;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "elementData=" + Arrays.toString(elementData) +
                ", elementCount=" + elementCount +
                '}';
    }

}
