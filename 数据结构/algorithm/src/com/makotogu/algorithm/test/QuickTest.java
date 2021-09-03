package com.makotogu.algorithm.test;

import com.makotogu.algorithm.sort.Quick;

import java.util.Arrays;

public class QuickTest {
    public static void main(String[] args) {
        Integer[] a = {1,10,2,9,3,8,4,7,5,6};
        Quick.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
