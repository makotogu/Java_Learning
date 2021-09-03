package com.makotogu.algorithm.linear;

import org.w3c.dom.Node;

public class LinkList<T> {
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
        return null;
    }
    public int indexOf(T t){
        return -1;
    }
}
