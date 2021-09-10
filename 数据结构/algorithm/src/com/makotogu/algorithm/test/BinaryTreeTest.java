package com.makotogu.algorithm.test;

import com.makotogu.algorithm.tree.BinaryTree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree<Integer, String> binaryTree = new BinaryTree<>();
        binaryTree.put(1,"张三");
        binaryTree.put(2,"李四");
        binaryTree.put(3,"王五");
        System.out.println("元素个数"+binaryTree.size());
        System.out.println(binaryTree.get(2));
        binaryTree.delete(2);
        System.out.println(binaryTree.size());
        System.out.println(binaryTree.get(3));
    }
}
