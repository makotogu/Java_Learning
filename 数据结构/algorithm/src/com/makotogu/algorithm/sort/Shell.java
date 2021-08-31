package com.makotogu.algorithm.sort;

public class Shell {

    public static void sort(Comparable[] a) {
        // 根据数组a的长度确定增长量的初始值
        int h = 1;
        while (h < (a.length / 2)) {
            h = 2 * h + 1;
        }
        while (h >= 1) {
            // 排序
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >= h; j -= h ) {
                    // 待插入元素a[j], 比较a[j]和a[j-h]
                    if (greater(a[j-h],a[j])) {
                        exch(a, j-h, j);
                    } else {
                        break;
                    }
                }
            }
            // 减小h的值
            h /= 2;
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
