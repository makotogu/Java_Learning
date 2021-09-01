package com.makotogu.algorithm.test;

import com.makotogu.algorithm.sort.Quick;

import java.util.Arrays;

public class QuickTest {
    public static void main(String[] args) {
        Integer[] a = {8,4,5,2,3,4,1,7,8};
        Quick.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
