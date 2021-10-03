package com.makotogu.java_interview;

import java.util.Arrays;

public class QuickSort1 {
    public static void main(String[] args) {
        int[] a = {5, 3, 7, 2, 9, 8, 1, 4};
        quick(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }

    public static void quick(int[] a, int l, int h) {
        if (l >= h) {
            return;
        }
        int partition = partition(a, l, h);
        // p 索引值
        quick(a, l, partition-1);
        quick(a, partition+1, h);
    }

    private static int partition (int[] a, int l, int h) {
        // 返回值代表了基准点元素所在的正确索引，用它来确定下一轮的边界

        int pv = a[h];
        // 基准点元素定位在最右侧

        int i = l;
        for (int j = l; j < h; j++) {
            if (a[j] < pv) {
                swap(a, i ,j);
                i++;
            }
        }
        if (i != h) {
            swap(a, h, i);
        }
        return i;
    }

    public static void swap (int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

