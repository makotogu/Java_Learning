package com.makotogu.algorithm.tree;

public class BinaryTree<Key extends Comparable<Key>, Value> {
    private Node root;
    private int N;
    private class Node {
        public Key key;
        private Value value;
        public Node left;
        public Node right;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
