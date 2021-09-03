package com.makotogu.algorithm.linear;

import java.util.Iterator;

public class TwoWayLinkList<T> implements Iterable<T>{
    private Node head;
    private Node last;
    private int N;
    private class Node {
        public Node(T item, Node pre, Node next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }

        public T item;
        public Node pre;
        public Node next;
    }

    public TwoWayLinkList() {
         this.head = new Node(null, null, null);
         this.last = null;
         N = 0;
    }

    public void clear() {
        this.head.next = null;
        this.last = null;
        this.N = 0;
    }
    public int length(){
        return N;
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public T getFirst() {
        if (isEmpty()) {
            return null;
        }
        return head.next.item;
    }
    public T getLast() {
        if (isEmpty()) {
            return null;
        }
        return last.item;
    }
    public void insert(T t) {
        if (isEmpty()) {
            Node newNode = new Node(t, head, null);
            last = newNode;
            head.next = last;
        } else {
            Node oldLast = last;
            Node newNode = new Node(t, oldLast, null);
            oldLast.next = newNode;
            last = newNode;
        }
        N++;
    }
    public void insert(int i, T t){
        Node pre = head;
        for (int index = 0; index < i; index++) {
            pre = pre.next;
        }
        Node cur = pre.next;
        Node newNode = new Node(t, pre, cur);
        pre.next = newNode;
        newNode.next = cur;
        N++;
    }
    public T get(int i) {
        Node node = head.next;
        for (int index = 0; index < i; index++) {
            node = node.next;
        }
        return node.item;
    }
    public int indexOf(T t) {
        Node node = head;
        int index = 0;
        while (node.next != null) {
            if (node.item == t) {
                return index;
            }
            index++;
        }
        return -1;
    }
    public T remove(int i) {
        Node pre = head;
        for (int index = 0; index < i; index++) {
            pre = pre.next;
        }
        Node cur = pre.next;
        Node nextNdoe = cur.next;
        pre.next = nextNdoe;
        nextNdoe.pre = pre;
        N--;
        return cur.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new TIterator();
    }
    private class TIterator implements Iterator {
        private Node n;
        public TIterator() {
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
