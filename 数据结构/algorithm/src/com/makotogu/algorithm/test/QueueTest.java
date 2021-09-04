package com.makotogu.algorithm.test;

import com.makotogu.algorithm.linear.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        Integer dequeue = queue.dequeue();
        System.out.println(dequeue);

        System.out.println("----");
        for (Integer num : queue) {
            System.out.println(num);
        }
    }
}
