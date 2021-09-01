package com.makotogu.algorithm.test;

import com.makotogu.algorithm.sort.Insertion;
import com.makotogu.algorithm.sort.Merge;
import com.makotogu.algorithm.sort.Quick;
import com.makotogu.algorithm.sort.Shell;

import java.io.*;
import java.util.ArrayList;

public class SortCompare {

    // 调用不同的测试方法，完成测试
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = new ArrayList<>();
        InputStream in = new FileInputStream("resources/reverse_arr.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            int i = Integer.parseInt(line);
            list.add(i);
        }
        bufferedReader.close();

        Integer[] integers = new Integer[list.size()];
        list.toArray(integers);
        testInsertion(integers);
        testShell(integers);
        testMerge(integers);
        testQuick(integers);
    }

    // 测试希尔排序
    public static void testShell(Integer[] a) {
        long start = System.currentTimeMillis();
        Shell.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("shell time:"+ (end - start) + "ms");
    }

    // 测试插入排序
    public static void testInsertion(Integer[] a) {
        long start = System.currentTimeMillis();
        Insertion.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("insertion time:"+ (end - start) + "ms");
    }

    // 测试归并排序
    public static void testMerge(Integer[] a) {
        long start = System.currentTimeMillis();
        Merge.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("merge time:"+ (end - start) + "ms");
    }

    public static void testQuick(Integer[] a) {
        long start = System.currentTimeMillis();
        Quick.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("merge time:"+ (end - start) + "ms");
    }
}
