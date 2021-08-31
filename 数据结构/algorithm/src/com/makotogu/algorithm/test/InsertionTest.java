package com.makotogu.algorithm.test;

import com.makotogu.algorithm.sort.Insertion;

import java.util.Arrays;

public class InsertionTest {

    public static void main(String[] args) {
        Integer[] arr = {4, 5, 6, 3, 2, 1, 7};
        Insertion.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
