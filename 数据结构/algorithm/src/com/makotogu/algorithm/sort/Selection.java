package com.makotogu.algorithm.sort;

public class Selection {

    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < a.length; j++) {
                if (greater(a[minIndex], a[j])){
                    minIndex = j;
                }
            }
            exch(a, i, minIndex);
        }
    }

    public static boolean greater(Comparable v, Comparable w) {
        return v.compareTo(w)>0;
    }

    public static void  exch(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
