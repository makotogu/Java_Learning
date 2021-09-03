package com.makotogu.algorithm.sort;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

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
            while (left < key && less(a[key],a[++left])) {
                exch(a, key, left);
                key = left;
                break;
            }
            while (right > key && less(a[--right],a[key])) {
                exch(a, key, right);
                key = right;
                break;
            }
            if (left >= right) {
                break;
            }
        }
        return key;
    }


}
