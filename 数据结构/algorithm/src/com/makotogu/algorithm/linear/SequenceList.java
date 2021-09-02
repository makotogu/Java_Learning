package com.makotogu.algorithm.linear;

import java.util.Iterator;

public class SequenceList<T> implements Iterable<T>{
    /**
     * 存储元素的数组
     */
    private T[] eles;

    /**
     * 记录当前顺序表中的元素个数
     */
    private int N;

    /**
     * 构造方法
     * @param capacity 容量
     */
    public SequenceList(int capacity) {
        // 初始化数组
        this.eles = (T[]) new Object[capacity];
        // 初始化长度
        this.N = 0;
    }

    /**
     * 将一个线性表置为空表
     */
    public void clear() {
        this.N = 0;
    }

    /**
     * 判断线性表是否为空表
     * @return 是否为空 空为true
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 获取线性表的长度
     * @return 长度
     */
    public int length() {
        return N;
    }

    /**
     * 获取指定位置的元素
     * @param i 位置
     * @return 指定位置的元素
     */
    public T get(int i) {
        return eles[i];
    }

    /**
     * 向线性表中插入元素t
     * @param t 被插入的元素
     */
    public void insert(T t) {
        if (N == eles.length) {
            resize(eles.length * 2);
        }
        eles[N++] = t;
    }

    /**
     * 向线性表的指定位置插入元素
     * @param i 插入的位置
     * @param t 插入的元素
     */
    public void insert(int i, T t) {
        if (N == eles.length) {
            resize(eles.length * 2);
        }
        for (int index = N; index > i; index --) {
            eles[index] = eles[index-1];
        }
        eles[i] = t;
        N++;
    }

    /**
     * 删除位置i的元素并返回
     * @param i 删除元素的位置
     * @return 被删除的元素
     */
    public T remove(int i) {
        T temp = eles[i];
        for (int index = i; index < N-1; index++) {
            eles[index] = eles[index + 1];
        }
        N--;

        if (N < (eles.length / 4)) {
            resize(eles.length / 2);
        }

        return temp;
    }

    /**
     * 返回元素出现的第一个位置
     * @param t 元素
     * @return 出现的位置
     */
    public int indexOf (T t){
        for (int i = 0; i < N; i++) {
            if (eles[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator {
        private int cusor;

        public SIterator() {
            this.cusor = 0;
        }

        @Override
        public boolean hasNext() {
            return cusor < N;
        }

        @Override
        public Object next() {
            return eles[cusor++];
        }
    }

    public void resize(int newSize) {
        // 定义一个临时数组，指向原数组
        T[] temp = eles;
        eles = (T[]) new Object[newSize];
        for (int i = 0; i < N; i++) {
            eles[i] = temp[i];
        }
    }
}
