package com.makotogu.algorithm.test;

import com.makotogu.algorithm.linear.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        for (Integer num : stack) {
            System.out.println(num);
        }
        System.out.println("----------");
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.size());

    }
}
