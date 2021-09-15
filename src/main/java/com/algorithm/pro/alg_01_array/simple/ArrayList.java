package com.algorithm.pro.alg_01_array.simple;

/**
 * @author frankq
 * @date 2021/9/14
 */
public class ArrayList implements List {
    /**
     * 容器默认容量大小
     */
    private static final int DEFAULT_CAPACITY = 8;
    /**
     * 存储元素的数组
     */
    private int[] elementData;
    /**
     * 容器中元素个数
     */
    private int size;

    public ArrayList() {
        this.elementData = new int[DEFAULT_CAPACITY];
    }

    public ArrayList(int initCapacity) {
        if (initCapacity > 0) {
            this.elementData = new int[initCapacity];
        } else {
            throw new IllegalArgumentException("initCapacity error " + initCapacity);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int indexOf(int o) {
        for (int i = 0; i < size; i ++) {
            if (elementData[i] == o) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(int e) {
        return indexOf(e) >= 0;
    }

    @Override
    public boolean add(int e) {
        ensureCapacity(size + 1);
        this.elementData[size ++] = e;
        return true;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > this.elementData.length) {
            grow(minCapacity);
        }
    }

    private void grow(int minCapacity) {
        int oldCapacity = this.elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity < minCapacity) {
            newCapacity = minCapacity;
        }
        // 使用新的容量大小创建新的数组，并且将原数组中的数据拷贝到新数组中
        copyOf(newCapacity);
    }

    private void copyOf(int newCapacity) {
        int[] newarray = new int[newCapacity];
        System.arraycopy(this.elementData, 0, newarray, 0, size);
        this.elementData = newarray;
    }

    @Override
    public void add(int index, int element) {
        rangeCheck(index);
        ensureCapacity(size + 1);
        System.arraycopy(this.elementData, index, this.elementData, index + 1, size - index);
        this.elementData[index] = element;
        size ++;
    }

    @Override
    public int set(int index, int element) {
        rangeCheck(index);
        int oldElement = this.elementData[index];
        this.elementData[index] = element;
        return oldElement;
    }

    @Override
    public int get(int index) {
        rangeCheck(index);
        return this.elementData[index];
    }

    @Override
    public int remove(int index) {
        rangeCheck(index);
        int oldValue = this.elementData[index];
        //要移动元素的个数
        int moveCount = size - index - 1;
        System.arraycopy(this.elementData,index+1,this.elementData,index,moveCount);
        //清理最后一个位置的元素
        this.elementData[size - 1] = 0;
        //容器中元素个数‐1
        size--;
        return oldValue;
    }

    private void rangeCheck(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index : " + index + ", size=" + this.size);
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = 0;
        }
        size = 0;
    }

    @Override
    public String toString() {
        //按照[1,2,3,5,6]的格式输出数组中的元素
        StringBuilder sb = new StringBuilder("[");
        for (int i=0 ;i < size; i++) {
            sb.append(this.elementData[i]).append(",");
        }
        sb.append("]");
        return sb.toString();
    }
}
