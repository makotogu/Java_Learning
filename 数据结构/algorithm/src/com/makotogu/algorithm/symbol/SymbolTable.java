package com.makotogu.algorithm.symbol;

public class SymbolTable<K, V> {
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

    public SymbolTable() {
        this.head = new Node(null, null, null);
        this.N = 0;
    }

    public int size() {
        return N;
    }

    public void put(K key, V value) {
        Node node = head;
        while (node.next != null) {
            node = node.next;
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        Node newNode = new Node(key, value, null);
        node.next = newNode;
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
    public V get(K key){
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
