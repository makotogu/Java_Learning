package com.makotogu.algorithm.sort;

public class Merge {
    private static Comparable[] assist;

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w)<0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * 对a元素进行排序
     * @param a 被操作数组
     */
    public static void sort(Comparable[] a) {
        assist = new Comparable[a.length];
        int lo = 0;
        int hi = a.length - 1;
        sort(a, lo, hi);

    }

    private static void sort(Comparable[] a, int lo, int hi) {
        // 做安全性检验
        if (hi <= lo) {
            return;
        }
        // 对lo到hi之间的数据分组
        int mid = lo + (hi - lo) / 2;
        // 分别对每一组数据进行排序
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    /**
     * 对数组中元素合并
     * @param a 数组
     * @param lo lo 的 index
     * @param mid mid 的 index
     * @param hi hi 的 index
     */
    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int leftPoint = lo;
        int rightPoint = mid+1;
        int assistPoint = lo;

        while (leftPoint <= mid && rightPoint <= hi) {
            if (less(a[leftPoint],a[rightPoint])) {
                assist[assistPoint] = a[leftPoint];
                assistPoint++;
                leftPoint++;
            } else {
                assist[assistPoint] = a[rightPoint];
                assistPoint++;
                rightPoint++;
            }
        }
        while (leftPoint <= mid) {
            assist[assistPoint] = a[leftPoint];
            assistPoint++;
            leftPoint++;
        }
        while (rightPoint <= hi) {
            assist[assistPoint] = a[rightPoint];
            assistPoint++;
            rightPoint++;
        }
        for (int index = lo; index <= hi; index++) {
            a[index] = assist[index];
        }
    }

}
