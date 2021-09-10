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
    public int size() {
        return N;
    }
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }
    private Node put(Node x, Key key, Value value) {
        if (x == null) {
            N++;
            return new Node(key, value, null, null);
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else {
            x.value = value;
        }
        return x;
    }
    public Value get(Key key) {
        return get(root, key);
    }
    public Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            return get(x.right, key);
        } else if (cmp < 0) {
            return get(x.left, key);
        } else {
            return x.value;
        }
    }
    public void delete(Key key) {
        delete(root, key);
    }
    public Node delete(Node x, Key key) {
        // x树为Null
        if (x == null) {
            return null;
        }
        // x树不为Null
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            x.right = delete(x.right, key);
        } else if (cmp < 0) {
            x.left = delete(x.left, key);
        } else {
            N--;
            // 找到一个结点替换当前节点 右子树的最左子结点
            if (x.right == null) {
                return x.left;
            }
            if (x.left == null) {
                return x.right;
            }
            Node node = x.right;
            Node minNode = null;
            while (node.left != null) {
                if (node.left.left == null) {
                    minNode = node.left;
                    if (minNode.right != null) {
                        node.left = minNode.right;
                    } else {
                        node.left = null;
                    }
                } else {
                    node = node.left;
                }
            }
            minNode.left = x.left;
            minNode.right = x.left;
            x = minNode;

        }
        return x;
    }

    public Key min() {
        return min(root).key;
    }
    public Node min(Node x) {
        if (x.left != null) {
            return min(x.left);
        } else {
            return x;
        }
    }
    public Key max() {
        return max(root).key;
    }
    public Node max(Node x) {
        if (x.right != null) {
            return max(x.right);
        } else {
            return x;
        }
    }

}
