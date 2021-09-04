package com.makotogu.algorithm.linear;

import java.util.Iterator;

public class Queue<T> implements Iterable<T>{
    private Node head;
    private Node last;
    private int N;

    private class Node {
        public T item;
        public Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public Queue() {
        this.head = new Node(null, null);
        this.last = null;
        this.N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(T t) {
        Node newNode = new Node(t, null);
        if (isEmpty()) {
            head.next = newNode;
            last = head.next;
        } else {
            last.next = newNode;
            last = last.next;
        }
        N++;
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        Node oldFirst = head.next;
        head.next = oldFirst.next;
        N--;
        if (isEmpty()) {
            last = null;
        }
        return oldFirst.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new QIterator();
    }

    private class QIterator implements Iterator<T> {
        private Node node;
        public QIterator() {
            this.node = head;
        }
        @Override
        public boolean hasNext() {
            return node.next != null;
        }

        @Override
        public T next() {
            node = node.next;
            return node.item;
        }
    }

}
