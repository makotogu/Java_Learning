package com.makotogu.algorithm.linear;

import java.util.Iterator;

public class LinkList<T> implements Iterable<T>{
    private Node head;
    private int N;

    private class Node {
        T item;
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public LinkList() {
        // 初始化头节点
        this.head = new Node(null, null);
        // 初始化元素个数
        this.N = 0;
    }
    public void clear() {
        head.next = null;
        N = 0;
    }
    public  int length() {
        return N;
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public T get(int i) {
        Node n = head.next;
        for (int index = 0; index < i; index++) {
            n = n.next;
        }
        return n.item;
    }
    public void insert(T t) {
        Node n = head;
        while (n.next != null) {
            n = n.next;
        }
        Node newNode = new Node(t, null);
        n.next = newNode;
        N++;
    }
    public void insert(int i, T t) {
        Node pre = head;
        for (int index = 0; index < i; index++ ) {
            pre = pre.next;
        }
        Node newNode = new Node(t, pre.next);
        pre.next = newNode;
        N++;
    }
    public T remove(int i) {
        Node pre = head;
        for (int index = 0 ; index < i; index++) {
            pre = pre.next;
        }
        Node cur = pre.next;
        pre.next = cur.next;
        N--;
        return cur.item;
    }
    public int indexOf(T t){
        Node node = head;
        int index = 0;
        while (node.next != null) {
            if (node.item.equals(t)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new LIterator();
    }

    private class LIterator implements Iterator{
        private Node n;
        public LIterator() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }
    }
}
