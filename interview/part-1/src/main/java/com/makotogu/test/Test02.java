package com.makotogu.test;

import java.util.HashMap;

/**
 * 说一下hashmap的put方法
 * 1. 根据key取通过哈希算法得到hashcode与与运算得出熟知的下标
 * 2. 如果数组下标未知元素为空，则将key喝value封装为Node对象并放入该位置
 * 3. 如果数组下标位置元素不为空，会判断当前位置的Node类型，是红黑树还是链表的Node
 * 4. 如果如果是红黑树node就将key和value封装为一个节点，并添加到其中，在这个过程中判断是否存在当前key，如果更新就更新value
 * 5. 如果位置上的Node对象是链表节点，则将key和value封装为一个Node并且通过尾插法放入到链表的最后。
 * 6. 将key和value封装为node插入到链表或红黑树中，再判断是否有选需要进行扩容，如果需要就扩容，
 *
 */
public class Test02 {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put('1',1);
    }
}
