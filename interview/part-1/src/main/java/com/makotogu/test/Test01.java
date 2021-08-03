package com.makotogu.test;

import java.util.ArrayList;
import java.util.LinkedList;

public class Test01 {

    /**
     * 说一下ArrayList和LinkedList的区别
     * arraylist数组、linkedlist 双向链表
     * ArrayList适合随机查找、linkedList适合删除、添加
     * ArrayList和LinkedList都实现了list接口，linkedList还实现了deque可以看做双向队列
     */

    public static void main(String[] args) {
        /**
         * 实现list接口
         */
        ArrayList arrayList = new ArrayList<>();
        /**
         * 实现了Deque接口
         */
        LinkedList linkedList = new LinkedList();

        /**
         * arraylist快
         */
        arrayList.get(1);//查询
        linkedList.get(1);//查询

        /**
         * 添加
         */
        arrayList.add(1);//扩容的话就慢
        arrayList.add(1,1);//需要移动的添加性能受到影响
        linkedList.add(1);
        linkedList.add(1,1);//对于链表而言扩容不需要扩容，但是需要遍历去找到下标
    }
}
