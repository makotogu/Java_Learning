package com.makotogu.algorithm.linear;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
    private Node head;
    private int N;

    private class Node {

        public T item;
        public Node next;
        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }

    }
    public Stack() {
        this.head = new Node(null, null);
        this.N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(T t) {
        // 找到首结点指向的第一个结点
        Node oldFirst = head.next;
        // 创建新结点
        Node newNode = new Node(t, null);
        // 让首结点指向新结点
        head.next = newNode;
        // 让新结点指向原来的第一个结点
        newNode.next = oldFirst;
        N++;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        Node oldFirst = head.next;
        head.next = oldFirst.next;
        N--;
        return oldFirst.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator {
        private Node node;

        public SIterator() {
            this.node = head;
        }

        @Override
        public boolean hasNext() {
            return node.next != null;
        }

        @Override
        public Object next() {
            node = node.next;
            return node.item;
        }
    }
}
