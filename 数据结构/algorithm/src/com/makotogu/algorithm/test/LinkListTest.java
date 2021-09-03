package com.makotogu.algorithm.test;

import com.makotogu.algorithm.linear.LinkList;

import java.util.LinkedList;

public class LinkListTest {

    public static void main(String[] args) {
        LinkList<Integer> integerLinkList = new LinkList<>();

        integerLinkList.insert(11);
        integerLinkList.insert(11);
        integerLinkList.insert(11);
        integerLinkList.insert(2,23);


        for (Integer integer : integerLinkList) {
            System.out.println(integer);
        }

    }
}
