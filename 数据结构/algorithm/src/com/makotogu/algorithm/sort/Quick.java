package com.makotogu.algorithm.sort;

import java.util.Random;

public class Quick {
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w)<0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static void sort(Comparable[] a) {
        int lo = 0;
        int hi = a.length - 1;
        sort(a, lo, hi);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int partition = partition(a, lo, hi);
        sort(a, lo,partition-1);
        sort(a, partition+1, hi);
    }


    private static int partition(Comparable[] a, int lo, int hi) {
        int key = new Random().nextInt(hi-lo)+lo;
        int left = lo-1;
        int right = hi+1;
        while (true) {
            while (less(a[key],a[--right]) && right > lo) {
            }
            while (less(a[++left],a[key]) && left < hi) {
            }
            if (left >= right) {
                break;
            } else {
                exch(a, left, right);
            }
        }
        return key;
    }

}
