package com.makotogu.algorithm.test;

import com.makotogu.algorithm.linear.LinkList;
import com.makotogu.algorithm.linear.TwoWayLinkList;

public class TwoWayLinkListTest {

    public static void main(String[] args) {
        TwoWayLinkList<Integer> twoWayLinkList = new TwoWayLinkList<>();

        twoWayLinkList.insert(11);
        twoWayLinkList.insert(12);
        twoWayLinkList.insert(13);
        twoWayLinkList.insert(2,23);
        twoWayLinkList.getLast();
        twoWayLinkList.remove(2);

        for (Integer integer : twoWayLinkList) {
            System.out.println(integer);
        }

    }
}
