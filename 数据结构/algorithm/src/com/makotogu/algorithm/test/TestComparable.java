package com.makotogu.algorithm.test;

import com.makotogu.algorithm.sort.Student;

public class TestComparable {

    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setAge(18);
        student1.setUsername("张三");

        Student student2 = new Student();
        student2.setAge(20);
        student2.setUsername("李四");

        System.out.println(getMax(student1,student2));
    }

    public static Comparable getMax(Comparable c1, Comparable c2){
        int result = c1.compareTo(c2);
        if (result >= 0) {
            return c1;
        } else {
            return c2;
        }
    }
}
