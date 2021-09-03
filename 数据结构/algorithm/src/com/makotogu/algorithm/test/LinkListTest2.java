package com.makotogu.algorithm.test;

import com.makotogu.algorithm.linear.LinkList;

public class LinkListTest2 {

    public static void main(String[] args) {
        LinkList<Integer> integerLinkList = new LinkList<>();

        integerLinkList.insert(1);
        integerLinkList.insert(2);
        integerLinkList.insert(3);
        integerLinkList.reverse();

        for (Integer integer : integerLinkList) {
            System.out.println(integer);
        }


    }
}
