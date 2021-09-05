package com.makotogu.algorithm.symbol;

public class OrderSymbolTable<K extends Comparable<K>, V> {
    private Node head;
    private int N;

    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public OrderSymbolTable() {
        this.head = new Node(null, null, null);
        this.N = 0;
    }

    public int size() {
        return N;
    }

    public void put(K key, V value) {
        // 定义两个node变量 分别记录当前结点和当前结点的上一个结点
        Node cur = head.next;
        Node pre = head;
        while (cur != null && key.compareTo(cur.key) > 0) {
            pre = cur;
            cur = cur.next;
        }
        if (cur != null && key.compareTo(cur.key) == 0) {
            cur.value = value;
            return;
        }
        Node newNode = new Node(key, value, cur);
        newNode.next = cur;
        N++;
    }

    public void delete(K key) {
        Node node = head;
        while (node.next != null) {
            if (node.next.key.equals(key)) {
                node.next = node.next.next;
                N--;
                return;
            }
            node = node.next;
        }
    }

    public V get(K key) {
        Node node = head;
        while (node.next != null) {
            node = node.next;
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }
}
