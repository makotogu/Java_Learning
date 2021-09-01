package com.makotogu.algorithm.test;

import com.makotogu.algorithm.linear.SequenceList;

public class SequenceListTest {

    public static void main(String[] args) {
        SequenceList<Integer> integerSequenceList = new SequenceList<Integer>(10);

        integerSequenceList.insert(1);
        integerSequenceList.insert(2);
        integerSequenceList.insert(3);
        integerSequenceList.insert(1,4);

        integerSequenceList.remove(2);
        for (Integer integer : integerSequenceList) {
            System.out.println(integer);
        }
        /*
        integerSequenceList.clear();
        System.out.println(integerSequenceList.length());
        */
    }
}
