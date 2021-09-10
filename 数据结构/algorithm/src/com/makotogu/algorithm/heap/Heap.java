package com.makotogu.algorithm.heap;

public class Heap<T extends Comparable<T>> {
    private T[] items;
    private int N;

    public Heap(int capacity) {
        this.items = (T[]) new Object[capacity];
        this.N = 0;
    }
    private boolean less(int i, int j) {
        return items[i].compareTo(items[j])<0;
    }
    private void exch(int i, int j) {
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }
    public void insert(T t) {
        items[++N] = t;
        swim(N);
    }
    private void swim(int k) {
        while (k > 1) {
            if (less(k/2, k)) {
                exch(k/2, k);
            }
            k = k / 2;
        }
    }
    public T delMax() {
        T max = items[1];
        exch(1, N);
        items[N] = null;
        N--;
        sink(1);
        return max;
    }
    private void sink(int k) {

    }
}
