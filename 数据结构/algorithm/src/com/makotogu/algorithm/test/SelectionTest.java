package com.makotogu.algorithm.test;

import com.makotogu.algorithm.sort.Selection;

import java.util.Arrays;

public class SelectionTest {

    public static void main(String[] args) {
        Integer[] arr = {4, 5, 6, 3, 2, 1};
        Selection.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
